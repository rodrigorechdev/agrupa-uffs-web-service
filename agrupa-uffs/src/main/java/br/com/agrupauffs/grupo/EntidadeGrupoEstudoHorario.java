package br.com.agrupauffs.grupo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "grupo_estudo_horario")
@Entity
public class EntidadeGrupoEstudoHorario {
    
    @Id
    @Column(name = "id_grupo_estudo_horario")
    Integer idGrupoEstudo;

    @ManyToOne
    @JoinColumn(name = "id_grupo_estudo")
    @Getter(AccessLevel.NONE)
    EntidadeGrupoDeEstudos grupoEstudo;

    @Column(name = "segunda")
    Boolean segunda;

    @Column(name = "terca")
    Boolean terca;
    
    @Column(name = "quarta")
    Boolean quarta;
    
    @Column(name = "quinta")
    Boolean quinta;
    
    @Column(name = "sexta")
    Boolean sexta;

    @Column(name = "sabado")
    Boolean sabado;

    @Column(name = "domingo")
    Boolean domingo;

    @Column(name = "data_marcada")
    Date dataMarcada;
    
    @Column(name = "hora_marcada")
    Date horaMarcada;

    @Column(name = "dt_atz")
    Date dataDeCriacaoDoRegistro;

    
}
