package br.com.agrupauffs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.ConsultasGruposBusiness;
import br.com.agrupauffs.controller.parametros.AceitaOuRecusaMembro;
import br.com.agrupauffs.controller.parametros.PesquisaGrupo;
import br.com.agrupauffs.controller.parametros.SolicitaEntrada;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import br.com.agrupauffs.grupo.EntidadeGrupoEstudoUsuario;

@RequestMapping("grupos/")
@RestController
public class GruposController {
	
	@Autowired
	ConsultasGruposBusiness consultasGruposBusiness;

	@RequestMapping(value = "id/{idGrupo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntidadeGrupoDeEstudos> consultaGrupoEspecifico (@PathVariable int idGrupo) {
		return consultasGruposBusiness.consultaGrupo(idGrupo);
	}

	@RequestMapping(value = "pendente/{idGrupo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntidadeGrupoEstudoUsuario>> consultaUsuariosPendentesEmGrupo (@PathVariable int idGrupo) {
		return consultasGruposBusiness.consultaUsuariosPendentesEmGrupo(idGrupo);
	}
	
	@RequestMapping(value = "pesquisa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntidadeGrupoDeEstudos>> pesquisaGrupoDeEstudo (@RequestBody PesquisaGrupo body) {
		return consultasGruposBusiness.pesquisaGrupoDeEstudo(body);
	}

	@RequestMapping(value = "membro/novo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void aceitaOuRecusaMembro (@RequestBody AceitaOuRecusaMembro body) {
		consultasGruposBusiness.aceitaOuRecusaMembro(body);
	}

	@RequestMapping(value = "entrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> usuarioSolicitaEntradaGrupo (@RequestBody SolicitaEntrada solicitaEntrada) {
		return consultasGruposBusiness.solicitaEntradaEmGrupo(solicitaEntrada);
	}

}
