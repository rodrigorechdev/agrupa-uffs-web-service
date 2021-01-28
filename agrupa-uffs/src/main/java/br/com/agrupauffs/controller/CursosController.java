package br.com.agrupauffs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.grupo.EntidadeCurso;
import br.com.agrupauffs.grupo.QueryCurso;

@RequestMapping("cursos")
@RestController
public class CursosController {
	
	@Autowired
	QueryCurso query;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntidadeCurso>> consultaCursos() {
		return new ResponseEntity<List<EntidadeCurso>>(query.consultaCursos(), HttpStatus.OK);
	}
}
