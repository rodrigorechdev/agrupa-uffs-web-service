package br.com.agrupauffs.grupo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	Integer idGrupoEstudoCurso;

	@OneToMany
	@JoinColumn(name = "id_grupo_estudo")
	List<EntidadeGrupoDeEstudos> grupoDeEstudos;

	@OneToMany
	@Column(name = "id_curso")
	List<EntidadeCurso> curso;

	@Column(name = "dt_atz")
	Date data;

}
