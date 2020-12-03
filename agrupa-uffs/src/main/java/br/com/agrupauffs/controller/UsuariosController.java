package br.com.agrupauffs.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrupauffs.DTO.LoginDTO;
import br.com.agrupauffs.business.usuarios.LoginBusiness;

@RequestMapping("usuarios/")
@RestController
public class UsuariosController {

	@RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean validarLogin(@RequestBody LoginDTO login){
		var loginBusiness = new LoginBusiness();
		return loginBusiness.validarLogin(login.getEmail(), login.getSenha());
	}
}

