package br.com.agrupauffs.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario_notificao")
@Entity
public class EntidadeNotificacao {

	@Id
	@Column(name = "id_usuario_notificacao")
	private Integer idUsuarioNotificacao;

	@Column(name = "notificacao")
	private String notificacao;

	@Column(name = "visualizada")
	private Boolean visualizada;
	
	@Column(name = "fl_convite")
	private Boolean flConvite;

	@ManyToOne
	@JoinColumn(name = "id_grupo_estudo")
	private EntidadeGrupoDeEstudos idGrupoEstudo;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private EntidadeUsuario idUsuario;

	@Column(name = "dt_atz")
	private Date data;

}
