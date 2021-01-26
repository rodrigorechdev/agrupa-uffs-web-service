package br.com.agrupauffs.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryNotificacao extends CrudRepository<EntidadeNotificacao, Integer> {
    
    @Transactional
    @Modifying
    @Query(value = "insert into usuario_notificacao (id_grupo_estudo, id_usuario, notificacao, visualizada, fl_convite) values (:idGrupo, :idUsuario, :mensagem, false, :convite)", nativeQuery = true)
    public void insereNaTabela(@Param("idGrupo") int idGrupo, @Param("idUsuario") int idUsuario, @Param("mensagem") String mensagem, @Param("convite") Boolean convite); 

    @Transactional
    @Modifying
    @Query(value = "update usuario_notificacao set visualizada = 'true' where id_usuario_notificacao = :idUsuarioNotificacao", nativeQuery = true)
    public void visualizaNotificacao(@Param("idUsuarioNotificacao") int idUsuarioNotificacao); 

    @Query(value = "select * from usuario_notificacao where id_usuario = :idUsuario", nativeQuery = true)
    public List<EntidadeNotificacao> notificacoesDeUsuario(@Param("idUsuario") int idUsuario); 
}
