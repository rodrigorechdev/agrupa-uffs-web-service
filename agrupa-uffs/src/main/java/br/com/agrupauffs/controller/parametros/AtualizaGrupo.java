package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaGrupo {
    private int id;
    private String nome;
    private String descricao;
    private Boolean privado;
}
