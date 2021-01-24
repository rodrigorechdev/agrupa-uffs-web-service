package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaGrupoEstudoUsuario {
    private Integer idGrupoEstudo;
    private Integer idUsuario;
    private Boolean administrador;
    private Boolean pedidoPendente;
}
