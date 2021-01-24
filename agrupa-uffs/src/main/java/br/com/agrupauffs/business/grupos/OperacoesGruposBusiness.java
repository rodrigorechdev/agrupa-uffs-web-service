package br.com.agrupauffs.business.grupos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agrupauffs.controller.parametros.AtualizaGrupo;
import br.com.agrupauffs.controller.parametros.DeleteGrupo;
import br.com.agrupauffs.controller.parametros.NovoGrupo;
import br.com.agrupauffs.grupo.EntidadeGrupoDeEstudos;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudos;

/**
 * Operações que não são consultas relacionadas aos grupos de estudo.
 */
@Service
public class OperacoesGruposBusiness {

    @Autowired
    QueryGrupoDeEstudos queryGrupoDeEstudos;

    /**
     * Cria novo grupo de estudos
     * @param novoGrupo
     */
    public Boolean criaGrupo(NovoGrupo novoGrupo) {
        try {
            queryGrupoDeEstudos.insereGrupo(novoGrupo.getNome(), novoGrupo.getDescricao(), novoGrupo.getPrivado());
            return true;
        }        
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deleta grupo de estudos baseado no id do grupo.
     * @param novoGrupo
     */
    public Boolean deletaGrupo(DeleteGrupo body) {
        try {
            queryGrupoDeEstudos.deletaGrupo(body.getIdGrupo());
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Atualiza grupo de estudos baseado no id desse grupo
     * @param body
     */
    public Boolean atualizaGrupo(AtualizaGrupo body) {
        try {
        queryGrupoDeEstudos.atualizaGrupo(body.getId(), body.getNome(), body.getDescricao(), body.getPrivado());
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
