package br.com.agrupauffs.usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryUsuario extends CrudRepository<EntidadeUsuario, Integer> {
    
    @Query(value = "select * from usuario where id_usuario = :idUsuario", nativeQuery = true)
    public EntidadeUsuario consultaUsuarioPorId(@Param("idUsuario") int idUsuario); 

    @Query(value = "select * from usuario where email = :email", nativeQuery = true)
    public EntidadeUsuario consultaUsuarioPorEmail(@Param("email") String email); 

}
