package br.com.agrupauffs.business.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agrupauffs.controller.parametros.VisualizaNotificacao;
import br.com.agrupauffs.usuario.QueryNotificacao;

@Service
public class UsuarioBusiness {
    
    @Autowired
    QueryNotificacao queryNotificacao;

    /**
     * Recebe o id de uma notificação e ela passa a ser marcada como visualizada.
     * @param body
     */
    public void visualizaNotificacao(VisualizaNotificacao body) {
        queryNotificacao.visualizaNotificacao(body.getIdNotificacao());
    }

}
