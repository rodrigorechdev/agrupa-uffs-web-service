package br.com.agrupauffs.grupo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "grupo_estudo")
@Entity
@ToString
public class EntidadeGrupoDeEstudos {
	
	@Id
	@Column(name = "id_grupo_estudo")
	private Integer idGrupo;

	@Column(name = "dt_atz")
	private Date data;

	@Column(name = "nm_grupo")
	private String nomeDoGrupo;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "privado")
	private Boolean privado;

	@OneToMany(mappedBy = "idGrupoDeEstudos") 
	private List<EntidadeGrupoEstudoUsuario> grupoEstudoUsuario;

	@OneToMany(mappedBy = "grupoDeEstudos")
    private List<EntidadeGrupoEstudoCurso> grupoEstudoCurso;
	
	@OneToMany(mappedBy = "grupoEstudo")
	private List<EntidadeGrupoEstudoHorario> grupoEstudoHorario;
	
}
