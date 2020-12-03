package br.com.agrupauffs.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.ConsultaUsuarioBusiness;

@RequestMapping("grupos/")
@RestController
public class GruposController {
	
	@RequestMapping(value = "grupo/{idGrupo}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void consultaUsuario(@PathVariable int idGrupo) {
		new ConsultaUsuarioBusiness(idGrupo);
	}
}
