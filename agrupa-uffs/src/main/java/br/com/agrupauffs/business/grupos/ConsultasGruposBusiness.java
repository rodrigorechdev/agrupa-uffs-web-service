package br.com.agrupauffs.business.grupos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.agrupauffs.controller.parametros.AceitaOuRecusaMembro;
import br.com.agrupauffs.controller.parametros.PesquisaGrupo;
import br.com.agrupauffs.controller.parametros.SolicitaEntrada;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import br.com.agrupauffs.grupo.EntidadeGrupoEstudoCurso;
import br.com.agrupauffs.grupo.EntidadeGrupoEstudoUsuario;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudos;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudosUsuario;
import br.com.agrupauffs.usuario.QueryNotificacao;
import br.com.agrupauffs.usuario.QueryUsuario;

@Service
public class ConsultasGruposBusiness {
	
	@Autowired
	QueryGrupoDeEstudos queryGrupoDeEstudos;

	@Autowired
	QueryGrupoDeEstudosUsuario queryGrupoDeEstudosUsuario;

	@Autowired
	QueryNotificacao queryNotificacao;

	@Autowired
	QueryUsuario queryUsuario;
	/**
	 * Endpoint recebe a chave de um grupo e consulta dados do grupo e usuários do grupo.
	 * @param idGrupo
	 * @return
	 */
	public ResponseEntity<EntidadeGrupoDeEstudos> consultaGrupo(int idGrupo) {
		EntidadeGrupoDeEstudos grupoDeEstudos = queryGrupoDeEstudos.consultaGrupoDeEstudoEspecifico(idGrupo);
		grupoDeEstudos.limpaApontamentos();
		return new ResponseEntity<>(grupoDeEstudos, HttpStatus.OK);
	}

	/**
	 * Endpoint recebe o "idCurso" ou um campo de pesquisa ou nenhum dos dois campos.
	 * Caso receba o "idCurso" no body da requisição retorna os grupos relacionados a este grupo.
	 * Caso receba o campo "pesquisa" no body da requisição retorna os grupos cujo nome tenha relação com a pesquisa.
	 * Caso não receba nenhum dos campos, retorna todos os grupos
	 * @param pesquisaGrupo
	 * @return
	 */
	public ResponseEntity<List<EntidadeGrupoDeEstudos>> pesquisaGrupoDeEstudo(PesquisaGrupo pesquisaGrupo) {
		String idCurso = pesquisaGrupo.getIdCurso();
		String pesquisa = pesquisaGrupo.getPesquisa();

		if(pesquisa != null && pesquisa.length() != 0) {
			var grupos = queryGrupoDeEstudos.consultaGrupoDeEstudosPorPesquisa(pesquisa);
			for(var grupo : grupos) {
				grupo.limpaApontamentos();
			}
			return new ResponseEntity<>(grupos, HttpStatus.OK);
		}

		if(idCurso != null && idCurso.length() != 0) {
			var grupos = queryGrupoDeEstudos.consultaGrupoDeEstudosCurso(idCurso);
			for(var grupo : grupos) {
				grupo.limpaApontamentos();
			}
			return new ResponseEntity<>(grupos, HttpStatus.OK);
		}

		var grupos = queryGrupoDeEstudos.consultaGrupoDeEstudos();
		for(var grupo : grupos) {
			grupo.limpaApontamentos();
		}

		return new ResponseEntity<>(grupos, HttpStatus.OK);
	}

	/**
	 * Endpoint recebe a chave de um grupo e consulta usuários com pedidos de entrada pendente neste grupo.
	 * @param idGrupo
	 * @return
	 */
	public ResponseEntity<List<EntidadeGrupoEstudoUsuario>> consultaUsuariosPendentesEmGrupo(int idGrupo) {
		EntidadeGrupoDeEstudos grupoDeEstudos = queryGrupoDeEstudos.consultaUsuariosPendentesEmGrupo(idGrupo);
		grupoDeEstudos.limpaApontamentos();
		List<EntidadeGrupoEstudoUsuario> usuariosPendentes = new ArrayList<EntidadeGrupoEstudoUsuario>();
		List<EntidadeGrupoEstudoUsuario> todosOsUsuarios = grupoDeEstudos.getGrupoEstudoUsuario();
		for(EntidadeGrupoEstudoUsuario usuario : todosOsUsuarios) {
			if(usuario.getPedidoPendente()) {
				usuariosPendentes.add(usuario);
			}
		}
		return new ResponseEntity<>(usuariosPendentes, HttpStatus.OK);
	}

	/**
	 *	Recebe se a entrada de um usuário foi aceita ou recusada em um grupo de estudos.
	 *	Altera o banco de dados baseado na aceitação ou exclusão.
	 ** @param body
	 * @return
	 */
	public void aceitaOuRecusaMembro(AceitaOuRecusaMembro body) {

		if(body.getAceitaMembro()) {
			queryGrupoDeEstudosUsuario.atualizaUsuario(body.getIdGrupo(), body.getIdUsuario());
		}
		else {
			queryGrupoDeEstudosUsuario.deletaUsuario(body.getIdGrupo(), body.getIdUsuario());
		}
	}

	/**
	 * Solicita entrada de usuário em grupo caso o grupo seja privado. Caso não seja o usuário entra automaticamente.
	 * @param solicitaEntrada
	 * @return
	 */
	public ResponseEntity<Boolean> solicitaEntradaEmGrupo(SolicitaEntrada solicitaEntrada) {
		int idGrupo = solicitaEntrada.getIdGrupo();
		int idUsuario = solicitaEntrada.getIdUsuario();
		EntidadeGrupoDeEstudos grupoDeEstudos = queryGrupoDeEstudos.consultaGrupoDeEstudoEspecifico(idGrupo);
		if(grupoDeEstudos.getPrivado()) {
			var usuario = queryUsuario.consultaUsuarioPorId(idUsuario);
			var grupo = queryGrupoDeEstudos.consultaGrupoDeEstudosPorId(idGrupo);
			String mensagemNotificacao = usuario.getNome() + " pediu para entrar no grupo " + grupo.getNomeDoGrupo();
			queryNotificacao.insereNaTabela(idGrupo, idUsuario, mensagemNotificacao, true);
			queryGrupoDeEstudosUsuario.insereNaTabela(idGrupo, idUsuario, true, false);
			
		}
		else {
			queryGrupoDeEstudosUsuario.insereNaTabela(idGrupo, idUsuario, false, false);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
