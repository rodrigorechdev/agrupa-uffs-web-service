package br.com.agrupauffs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.ConsultaUsuarioBusiness;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudos;

@RequestMapping("grupos/")
@RestController
public class GruposController {
	
	@Autowired
	QueryGrupoDeEstudos queryGrupoDeEstudos;
	//"grupo/{idGrupo}"
	@RequestMapping(value = "grupo", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
	public void consultaUsuario(/*@PathVariable int idGrupo*/) {
		//new ConsultaUsuarioBusiness(idGrupo);
		List<EntidadeGrupoDeEstudos> x = queryGrupoDeEstudos.consultaGrupoDeEstudos();
	}
}
