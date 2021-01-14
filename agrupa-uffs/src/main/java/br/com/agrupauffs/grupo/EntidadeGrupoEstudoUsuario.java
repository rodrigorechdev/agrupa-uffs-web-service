package br.com.agrupauffs.grupo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.agrupauffs.usuario.EntidadeUsuario;

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
