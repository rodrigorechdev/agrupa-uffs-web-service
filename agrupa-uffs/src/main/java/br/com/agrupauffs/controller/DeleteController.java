package br.com.agrupauffs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.OperacoesGruposBusiness;
import br.com.agrupauffs.controller.parametros.DeleteGrupo;
import br.com.agrupauffs.controller.parametros.DeleteGrupoHorario;

@RequestMapping("delete/")
@RestController
public class DeleteController {
   
    @Autowired
    OperacoesGruposBusiness operacoesGruposBusiness;

    @RequestMapping(value = "grupo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deletaGrupo (@RequestBody DeleteGrupo body) {
		return operacoesGruposBusiness.deletaGrupo(body);
	}

    
    @RequestMapping(value = "grupo_horario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deletaGrupoHorario (@RequestBody DeleteGrupoHorario body) {
		return operacoesGruposBusiness.deletaGrupoHorario(body);
	}
}
