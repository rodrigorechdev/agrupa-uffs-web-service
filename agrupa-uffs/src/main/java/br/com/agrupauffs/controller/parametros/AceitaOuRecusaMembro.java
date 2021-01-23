package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AceitaOuRecusaMembro {
    private int idUsuario;
    private int idGrupo;
    private Boolean aceitaMembro;//se for false o convite é recusado
}
