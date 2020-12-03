package br.com.agrupauffs.business;

public class LoginBusiness {
	
	public boolean validarLogin(String email, String senha){
		return email.equals("Joao") && senha.equals("123456");
	}
}
