package br.com.agrupauffs.usuario;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.agrupauffs.grupo.EntidadeGrupoEstudoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario")
@Entity
public class EntidadeUsuario {

	@Id
	@Column(name = "id_usuario")
	Integer idUsuario;
	
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

	@OneToMany(mappedBy = "idUsuario")
    private List<EntidadeUsuarioCursos> entidadeUsuarioCursos;
	
	@OneToMany(mappedBy = "usuario")
	private List<EntidadeGrupoEstudoUsuario> entidadeGrupoEstudoUsuario;

	public void limpaApontamentos(){
		for(var registro : this.entidadeUsuarioCursos) {
			registro.setIdUsuario(null);
		}

		for(var registro : this.entidadeGrupoEstudoUsuario) {
			registro.setUsuario(null);
			registro.getIdGrupoDeEstudos().setGrupoEstudoCurso(null);
			registro.getIdGrupoDeEstudos().setGrupoEstudoHorario(null);
			registro.getIdGrupoDeEstudos().setGrupoEstudoUsuario(null);
		}
	}
}
