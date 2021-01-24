package br.com.agrupauffs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.OperacoesGruposBusiness;
import br.com.agrupauffs.controller.parametros.NovoGrupo;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;

@RequestMapping("insert/")
@RestController
public class InsertsController {
    
    @Autowired
    OperacoesGruposBusiness operacoesGruposBusiness;

    @RequestMapping(value = "grupo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean consultaGrupoEspecifico (@RequestBody NovoGrupo novoGrupo) {
		return operacoesGruposBusiness.criaGrupo(novoGrupo);
	}

}
