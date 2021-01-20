package br.com.agrupauffs.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario")
@Entity
public class EntidadeUsuario {

	@Id
	@Column(name = "id_usuario")
	String idUsuario;
	
	@Column(name = "cd_usuario")
	String usuario;
	
	@Column(name = "senha")
	String senha;
	
	@Column(name = "email")
	String email;
	
}
