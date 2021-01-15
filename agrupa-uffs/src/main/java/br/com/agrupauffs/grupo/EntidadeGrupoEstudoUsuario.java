package br.com.agrupauffs.grupo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.agrupauffs.usuario.EntidadeUsuario;

// @Entity se eu coloco dá erro, ver resposta do JAD https://stackoverflow.com/questions/40058001/error-creating-bean-with-name-entitymanagerfactory-defined-in-class-path-resou
@Table(name = "grupo_estudo_usuario")
public class EntidadeGrupoEstudoUsuario {

	@ManyToOne 
	@JoinColumn(name = "id_grupo_estudo")
	EntidadeGrupoDeEstudos grupoDeEstudos;
	
	@ManyToOne 
	@JoinColumn(name = "id_grupo_estudo")
	EntidadeUsuario usuario;
	
	@Column(name = "administrador")
	boolean administrador;
	
	
}
