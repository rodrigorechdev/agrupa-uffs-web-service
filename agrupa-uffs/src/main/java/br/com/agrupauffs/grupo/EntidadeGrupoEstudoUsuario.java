package br.com.agrupauffs.grupo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.agrupauffs.usuario.EntidadeUsuario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "grupo_estudo_usuario")
public class EntidadeGrupoEstudoUsuario {

	@Id
	@Column(name = "id_grupo_estudo_usuario")
	private Integer idGrupoEstudoUsuario;

	@ManyToOne
	@JoinColumn(name = "id_grupo_estudo")
	private EntidadeGrupoDeEstudos idGrupoDeEstudos;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private EntidadeUsuario usuario;
	
	@Column(name = "administrador")
	private Boolean administrador;

		
	@Column(name = "pedido_pendente")
	private Boolean pedidoPendente;

	@Column(name = "dt_atz")
	private Date data;


}
