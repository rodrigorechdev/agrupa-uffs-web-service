package br.com.agrupauffs.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.agrupauffs.grupo.EntidadeCurso;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario_perfil_cursos_interesse")
@Entity
public class EntidadeUsuarioCursos {

	@Id
	@Column(name = "id_usuario_perfil_cursos_interesse")
	Integer idUsuarioPerfilCursosInteresse;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	EntidadeUsuario idUsuario;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	EntidadeCurso idCurso;
	
	@Column(name = "dt_atz")
	Date data;
	
}
