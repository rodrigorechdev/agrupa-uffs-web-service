package br.com.agrupauffs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.grupos.OperacoesGruposBusiness;
import br.com.agrupauffs.controller.parametros.DeletaGrupoEstudoUsuario;
import br.com.agrupauffs.controller.parametros.DeletaUsuarioCursos;
import br.com.agrupauffs.controller.parametros.DeleteGrupo;
import br.com.agrupauffs.controller.parametros.DeleteGrupoHorario;
import br.com.agrupauffs.controller.parametros.DeleteUsuario;

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

	@RequestMapping(value = "grupo_estudo_usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deletaGrupoHorario (@RequestBody DeletaGrupoEstudoUsuario body) {
		return operacoesGruposBusiness.deletaGrupoEstudoUsuario(body);
	}

	@RequestMapping(value = "usuario_cursos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deletaGrupoHorario (@RequestBody DeletaUsuarioCursos body) {
		return operacoesGruposBusiness.deletaUsuarioCursos(body);
	}

	@RequestMapping(value = "usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deletaUsuario (@RequestBody DeleteUsuario body) {
		return operacoesGruposBusiness.deletaUsuario(body);
	}
}
