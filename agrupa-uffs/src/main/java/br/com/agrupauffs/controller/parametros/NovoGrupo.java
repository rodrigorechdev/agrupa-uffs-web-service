package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoGrupo {
    private String nome;
    private String descricao;
    private Boolean privado;
}
