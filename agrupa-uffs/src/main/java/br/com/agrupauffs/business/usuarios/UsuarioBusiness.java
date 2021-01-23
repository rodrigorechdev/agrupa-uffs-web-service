package br.com.agrupauffs.business.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agrupauffs.controller.parametros.Login;
import br.com.agrupauffs.controller.parametros.NotificacoesDeUsuario;
import br.com.agrupauffs.controller.parametros.VisualizaNotificacao;
import br.com.agrupauffs.usuario.EntidadeNotificacao;
import br.com.agrupauffs.usuario.EntidadeUsuario;
import br.com.agrupauffs.usuario.QueryNotificacao;
import br.com.agrupauffs.usuario.QueryUsuario;

@Service
public class UsuarioBusiness {
    
    @Autowired
    QueryNotificacao queryNotificacao;

    @Autowired
    QueryUsuario queryUsuario;

    /**
     * Recebe o id de uma notificação e ela passa a ser marcada como visualizada.
     * @param body
     */
    public void visualizaNotificacao(VisualizaNotificacao body) {
        queryNotificacao.visualizaNotificacao(body.getIdNotificacao());
    }

    public EntidadeUsuario consultaUsuario(String email) {
        EntidadeUsuario usuario = queryUsuario.consultaUsuarioPorEmail(email);
        usuario.limpaApontamentos();
        return usuario;
    }

    /**
     * Consulta usuário por e-mail
     * @param email
     * @return
     */
    public EntidadeUsuario consultaUsuario(String email) {
        EntidadeUsuario usuario = queryUsuario.consultaUsuarioPorEmail(email);
        usuario.limpaApontamentos();
        return usuario;
    }

    /**
     * Retorna todas as notificações de um usuário
     * @param body
     * @return
     */
    public List<EntidadeNotificacao> notificacoesDeUsuario(NotificacoesDeUsuario body) {
        return queryNotificacao.notificacoesDeUsuario(body.getIdUsuario());
    }

    public boolean validarLogin(Login login) {
        try {
            EntidadeUsuario usuario = queryUsuario.consultaUsuarioPorEmail(login.getEmail());
            usuario.limpaApontamentos();
            String senhaCorreta = usuario.getSenha();
            return senhaCorreta.equals(login.getSenha());
        }
        catch(Exception e) {
            return false;
        }
	}
}
