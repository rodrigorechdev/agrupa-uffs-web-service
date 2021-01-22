package br.com.agrupauffs.business.grupos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import br.com.agrupauffs.controller.parametros.PesquisaGrupo;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import br.com.agrupauffs.grupo.EntidadeGrupoEstudoUsuario;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudos;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudosUsuario;

@Repository
public class ConsultasGruposBusiness {
	
	@Autowired
	QueryGrupoDeEstudos queryGrupoDeEstudos;

	@Autowired
	QueryGrupoDeEstudosUsuario queryGrupoDeEstudosUsuario;

	/**
	 * Endpoint recebe a chave de um grupo e consulta dados do grupo e usuários do grupo.
	 * @param idGrupo
	 * @return
	 */
	public ResponseEntity<EntidadeGrupoDeEstudos> consultaGrupo(int idGrupo) {
		EntidadeGrupoDeEstudos grupoDeEstudos = queryGrupoDeEstudos.consultaGrupoDeEstudoEspecifico(idGrupo);
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
			return new ResponseEntity<>(queryGrupoDeEstudos.consultaGrupoDeEstudosPorPesquisa(pesquisa), HttpStatus.OK);
		}

		if(idCurso != null && idCurso.length() != 0) {
			return new ResponseEntity<>(queryGrupoDeEstudos.consultaGrupoDeEstudosCurso(idCurso), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(queryGrupoDeEstudos.consultaGrupoDeEstudos(), HttpStatus.OK);
	}

	/**
	 * Endpoint recebe a chave de um grupo e consulta usuários com pedidos de entrada pendente neste grupo.
	 * @param idGrupo
	 * @return
	 */
	public ResponseEntity<List<EntidadeGrupoEstudoUsuario>> consultaUsuariosPendentesEmGrupo(int idGrupo) {
		EntidadeGrupoDeEstudos grupoDeEstudos = queryGrupoDeEstudos.consultaGrupoDeEstudoEspecifico(idGrupo);
		List<EntidadeGrupoEstudoUsuario> usuariosPendentes = new ArrayList<EntidadeGrupoEstudoUsuario>();
		List<EntidadeGrupoEstudoUsuario> todosOsUsuarios = grupoDeEstudos.getGrupoEstudoUsuario();
		for(EntidadeGrupoEstudoUsuario usuario : todosOsUsuarios) {
			if(usuario.getPedidoPendente()) {
				usuariosPendentes.add(usuario);
			}
		}
		return new ResponseEntity<>(usuariosPendentes, HttpStatus.OK);
	}

	// To do
	// /**
	//  * Solicita entrada de usuário em grupo caso o grupo seja privado. Caso não seja o usuário entra automaticamente.
	//  * @param solicitaEntrada
	//  * @return
	//  */
	// public ResponseEntity<Boolean> solicitaEntradaEmGrupo(SolicitaEntrada solicitaEntrada) {
	// 	int idGrupo = solicitaEntrada.getIdGrupo();
	// 	int idUsuario = solicitaEntrada.getIdUsuario();
	// 	EntidadeGrupoDeEstudos grupoDeEstudos = queryGrupoDeEstudos.consultaGrupoDeEstudoEspecifico(idGrupo);
	// 	if(grupoDeEstudos.getPrivado()) {
	// 		//to do
	// 		//implementar notificacao
	// 	}
	// 	else {
	// 		queryGrupoDeEstudosUsuario.insereNaTabela(idGrupo, idUsuario);
	// 	}
	// 	return new ResponseEntity<>(true, HttpStatus.OK);
	// }
}
