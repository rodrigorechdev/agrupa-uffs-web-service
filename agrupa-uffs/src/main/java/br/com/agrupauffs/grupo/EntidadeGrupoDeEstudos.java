package br.com.agrupauffs.grupo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "grupo_estudo")
@Entity
public class EntidadeGrupoDeEstudos {
	
	@Id
	@Column(name = "id_grupo_estudo")
	int id;

	@Column(name = "dt_atz")
	Date data;

	@Column(name = "nm_grupo")
	String nomeDoGrupo;

	@Column(name = "descricao")
	String descricao;
	
	@Column(name = "privado")
	Boolean privado;
	 
}
