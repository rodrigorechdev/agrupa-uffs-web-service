package br.com.agrupauffs.business.grupos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import br.com.agrupauffs.controller.parametros.PesquisaGrupo;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudos;

@Repository
public class ConsultaUsuarioBusiness {
	
	@Autowired
	QueryGrupoDeEstudos queryGrupoDeEstudos;

	// public ResponseEntity<Object> consultaUsuario(int idGrupo) {
	// 	return new ResponseEntity<>(queryGrupoDeEstudos.consultaGrupoDeEstudos(idGrupo), HttpStatus.OK);
	// 	List<EntidadeGrupoDeEstudos> gruposDeEstudo = queryGrupoDeEstudos.consultaGrupoDeEstudos(idGrupo);
	// 	if(gruposDeEstudo.size() != 0) {
	// 		return new ResponseEntity<>(queryGrupoDeEstudos.consultaGrupoDeEstudos(idGrupo), HttpStatus.OK);
	// 	}
	// 	else {
	// 		return new ResponseEntity<>(null, HttpStatus.OK);
	// 	}
	// }

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
}
