package br.com.agrupauffs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.business.usuarios.UsuarioBusiness;
import br.com.agrupauffs.controller.parametros.Login;
import br.com.agrupauffs.controller.parametros.NotificacoesDeUsuario;
import br.com.agrupauffs.controller.parametros.VisualizaNotificacao;
import br.com.agrupauffs.usuario.EntidadeNotificacao;
import br.com.agrupauffs.usuario.EntidadeUsuario;


@RequestMapping("usuarios/")
@RestController
public class UsuariosController {

	@Autowired
	UsuarioBusiness usuarioBusiness;

	@RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean validarLogin(@RequestBody Login login) {
		return usuarioBusiness.validarLogin(login);
	}

	@RequestMapping(value = "notificacao/visualiza", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void visualizaNotificacao(@RequestBody VisualizaNotificacao body) {
		usuarioBusiness.visualizaNotificacao(body);
	}

	@RequestMapping(value = "consulta/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EntidadeUsuario visualizaNotificacao(@PathVariable String email) {
		return usuarioBusiness.consultaUsuario(email);
	}

	@RequestMapping(value = "notificacao/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EntidadeNotificacao> encontraNotificacoesDeUsuario(@RequestBody NotificacoesDeUsuario body) {
		return usuarioBusiness.notificacoesDeUsuario(body);
	}

}

