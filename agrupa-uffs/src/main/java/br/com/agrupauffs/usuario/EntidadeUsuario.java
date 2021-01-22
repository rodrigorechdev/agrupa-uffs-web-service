package br.com.agrupauffs.usuario;

import java.util.Date;

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

	@Column(name = "nome")
	String nome;
	
	@Column(name = "descricao")
	String descricao;
	
	@Column(name = "endereco")
	String endereco;
	
	@Column(name = "foto")
	String fotoBase64;

	@Column(name = "dt_atz")
	Date data;
	
}
