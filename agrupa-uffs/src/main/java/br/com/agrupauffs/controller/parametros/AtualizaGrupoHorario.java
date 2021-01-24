package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaGrupoHorario {
    private int idGrupoEstudoHorario;
    private int idGrupoEstudo;
    private Boolean segunda;
    private Boolean terca;
    private Boolean quarta;
    private Boolean quinta;
    private Boolean sexta;
    private Boolean sabado;
    private Boolean domingo;
    private String dataMarcada;
    private String horaMarcada;
}
