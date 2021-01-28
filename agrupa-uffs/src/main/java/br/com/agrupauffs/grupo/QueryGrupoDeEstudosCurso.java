package br.com.agrupauffs.grupo;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryGrupoDeEstudosCurso extends CrudRepository<EntidadeGrupoEstudoUsuario, Integer>{

    @Transactional
    @Modifying
    @Query(value = "insert into grupo_estudo_curso (id_grupo_estudo, id_curso, dt_atz) values (:idGrupo , :idCurso, :dt_atz)", nativeQuery = true)
    public void insert(@Param("idGrupo") int idGrupo, @Param("idCurso") int idCurso, @Param("dt_atz") Date data); 
    
    @Transactional
    @Modifying
    @Query(value = "delete from grupo_estudo_curso where id_grupo_estudo = :idGrupo", nativeQuery = true)
    public void clear(@Param("idGrupo") int idGrupo); 
}
