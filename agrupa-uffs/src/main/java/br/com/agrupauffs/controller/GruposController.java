package br.com.agrupauffs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.ConsultaUsuarioBusiness;
import br.com.agrupauffs.controller.parametros.PesquisaGrupo;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;

@RequestMapping("grupos/")
@RestController
public class GruposController {
	
	@Autowired
	ConsultaUsuarioBusiness consultaUsuarioBusiness;

	// @RequestMapping(value = "grupo/{idGrupo}", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
	// public ResponseEntity<Object> consultaUsuario (@PathVariable int idGrupo) {
	// 	//new ConsultaUsuarioBusiness(idGrupo);
	// 	return consultaUsuarioBusiness.consultaUsuario(idGrupo);
	// }

	@RequestMapping(value = "grupo/pesquisa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntidadeGrupoDeEstudos>> pesquisaGrupoDeEstudo (@RequestBody PesquisaGrupo pesquisaGrupo) {
		return consultaUsuarioBusiness.pesquisaGrupoDeEstudo(pesquisaGrupo);
	}
}
