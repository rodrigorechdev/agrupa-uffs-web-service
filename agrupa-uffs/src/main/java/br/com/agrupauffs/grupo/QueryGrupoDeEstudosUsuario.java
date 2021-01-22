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
    @Query(value = "insert into grupo_estudo_usuario (id_grupo_estudo, id_usuario, administrador, pedido_pendente) values (:idGrupo , :idUsuario, false, true)", nativeQuery = true)
    void insereNaTabela(@Param("idGrupo") int idGrupo, @Param("idUsuario") int idUsuario); 
    
}
