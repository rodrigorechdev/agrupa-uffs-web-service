package br.com.agrupauffs.business.grupos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agrupauffs.controller.parametros.AtualizaGrupo;
import br.com.agrupauffs.controller.parametros.AtualizaGrupoHorario;
import br.com.agrupauffs.controller.parametros.DeleteGrupo;
import br.com.agrupauffs.controller.parametros.DeleteGrupoHorario;
import br.com.agrupauffs.controller.parametros.NovoGrupo;
import br.com.agrupauffs.controller.parametros.NovoGrupoHorario;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudos;
import br.com.agrupauffs.grupo.QueryGrupoDeEstudosHorario;

/**
 * Operações que não são consultas relacionadas aos grupos de estudo.
 */
@Service
public class OperacoesGruposBusiness {

    @Autowired
    QueryGrupoDeEstudos queryGrupoDeEstudos;

    @Autowired
    QueryGrupoDeEstudosHorario queryGrupoDeEstudosHorario;
    
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

    /**
     * Deleta grupo_horario baseado no id do grupo_horario.
     */
    public Boolean deletaGrupoHorario(DeleteGrupoHorario body) {
        if(body.getId() == null) {
            return false;
        }
        try {
            queryGrupoDeEstudosHorario.deleta(body.getId());
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cria novo grupo_estudos_horarios
     * @param novoGrupo
     */
    public Boolean criaGrupoEstudoHorarios(NovoGrupoHorario novoGrupoHorario) {
        try {
            queryGrupoDeEstudosHorario.insere(
                novoGrupoHorario.getIdGrupoEstudo(), novoGrupoHorario.getSegunda(), novoGrupoHorario.getTerca(),
                novoGrupoHorario.getQuarta(), novoGrupoHorario.getQuinta(), novoGrupoHorario.getSexta(),
                novoGrupoHorario.getSabado(), novoGrupoHorario.getDomingo(),
                novoGrupoHorario.getDataMarcada() , novoGrupoHorario.getHoraMarcada()
            );
            return true;
        }        
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Atualiza grupo_estudos_horario baseado no id desse grupo
     * @param body
     */
    public Boolean atualizaGrupoHorario(AtualizaGrupoHorario body) {
        try {
            queryGrupoDeEstudosHorario.atualiza(
                body.getIdGrupoEstudo(), body.getSegunda(), body.getTerca(),
                body.getQuarta(), body.getQuinta(), body.getSexta(),
                body.getSabado(), body.getDomingo(),
                body.getDataMarcada() , body.getHoraMarcada(), body.getIdGrupoEstudoHorario()
            );            
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
