package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

/**
 * Parametro recebido quando usuário solicita entrada em grupo
 */
@Getter
@Setter
public class SolicitaEntrada {
    private int idUsuario;
    private int idGrupo;
}
