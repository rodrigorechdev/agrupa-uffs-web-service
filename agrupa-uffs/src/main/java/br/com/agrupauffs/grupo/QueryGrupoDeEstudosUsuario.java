package br.com.agrupauffs.grupo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryGrupoDeEstudosUsuario extends CrudRepository<EntidadeGrupoEstudoUsuario, Integer>{

    @Transactional
    @Modifying
    @Query(value = "insert into grupo_estudo_usuario (id_grupo_estudo, id_usuario, administrador, pedido_pendente) values (:idGrupo , :idUsuario, :administrador, :pedidoPendente)", nativeQuery = true)
    public void insereNaTabela(@Param("idGrupo") int idGrupo, @Param("idUsuario") int idUsuario, @Param("pedidoPendente") boolean pedidoPendente, @Param("administrador") boolean administrador); 
    
    @Transactional
    @Modifying
    @Query(value = "update grupo_estudo_usuario set pedido_pendente = 'false' where id_grupo_estudo = :idGrupo and id_usuario = :idUsuario", nativeQuery = true)
    public void atualizaUsuario(@Param("idGrupo") int idGrupo, @Param("idUsuario") int idUsuario); 
    
    @Transactional
    @Modifying
    @Query(value = "delete from grupo_estudo_usuario where id_grupo_estudo = :idGrupo and id_usuario = :idUsuario", nativeQuery = true)
    public void deletaUsuario(@Param("idGrupo") int idGrupo, @Param("idUsuario") int idUsuario); 

    @Transactional
    @Modifying
    @Query(value = "update grupo_estudo_usuario set pedido_pendente = :pedidoPendente, administrador = :administrador where id_grupo_estudo = :idGrupo and id_usuario = :idUsuario", nativeQuery = true)
    public void atualizaUsuarioCompleto(@Param("pedidoPendente") boolean pedidoPendente, @Param("administrador") boolean administrador, @Param("idGrupo") int idGrupo, @Param("idUsuario") int idUsuario); 
    
}
