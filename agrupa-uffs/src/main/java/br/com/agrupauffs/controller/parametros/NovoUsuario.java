package br.com.agrupauffs.controller.parametros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoUsuario {
    private String cdUsuario; 
    private String senha;
    private String email;
    private String nome; 
    private String endereco;
    private String descricao;
}
