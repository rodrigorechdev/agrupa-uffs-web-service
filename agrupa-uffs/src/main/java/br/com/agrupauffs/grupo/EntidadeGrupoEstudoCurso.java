package br.com.agrupauffs.grupo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "grupo_estudo_curso")
@Entity
public class EntidadeGrupoEstudoCurso {

	@Id
	@Column(name = "id_grupo_estudo_curso")
	private Integer idGrupoEstudoCurso;

	@ManyToOne
	@JoinColumn(name = "id_grupo_estudo")
	private EntidadeGrupoDeEstudos grupoDeEstudos;

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private EntidadeCurso curso;

	@Column(name = "dt_atz")
	private Date data;

}
