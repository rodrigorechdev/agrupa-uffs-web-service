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
@Table(name = "curso")
@Entity
public class EntidadeCurso {
    
    @Id
	@Column(name = "id_curso")
	int idCurso;

	@Column(name = "nm_curso")
	String nomeCurso;

	@Column(name = "descricao")
	String descricao;

	@Column(name = "dt_atz")
	Date data;

}
