package br.com.agrupauffs.grupo;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryGrupoDeEstudosHorario extends CrudRepository<EntidadeGrupoEstudoHorario, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from grupo_estudo_horario where id_grupo_estudo_horario = ':id'", nativeQuery = true)
    public void deleta(@Param("id") Integer id); 

    @Transactional
    @Modifying
    @Query(value = "insert into grupo_estudo_horario (id_grupo_estudo, segunda, terca, quarta, quinta, sexta, sabado, domingo, data_marcada, hora_marcada) values (:idGrupoEstudo, :segunda, :terca, :quarta, :quinta, :sexta, :sabado, :domingo, CAST (:dataMarcada AS date), CAST (:horaMarcada AS time))", nativeQuery = true)
    public void insere(@Param("idGrupoEstudo") int idGrupoEstudo, @Param("segunda") Boolean segunda, 
    @Param("terca") Boolean terca, @Param("quarta") Boolean quarta, @Param("quinta") Boolean quinta,
    @Param("sexta") Boolean sexta, @Param("sabado") Boolean sabado, @Param("domingo") Boolean domingo,  @Param("dataMarcada") String dataMarcada, @Param("horaMarcada") String horaMarcada); 

    @Transactional
    @Modifying
    @Query(value = "update grupo_estudo_horario set id_grupo_estudo = :idGrupoEstudo, segunda = :segunda, terca = :terca, quarta = :quarta, quinta = :quinta, sexta = :sexta, sabado = :sabado, domingo = :domingo, data_marcada = CAST (:dataMarcada AS date), hora_marcada = CAST (:horaMarcada AS time) where id_grupo_estudo_horario = :idGrupoEstudoHorario", nativeQuery = true)
    public void atualiza(@Param("idGrupoEstudo") int idGrupoEstudo, @Param("segunda") Boolean segunda, 
    @Param("terca") Boolean terca, @Param("quarta") Boolean quarta, @Param("quinta") Boolean quinta,
    @Param("sexta") Boolean sexta, @Param("sabado") Boolean sabado, @Param("domingo") Boolean domingo,  
    @Param("dataMarcada") String dataMarcada, @Param("horaMarcada") String horaMarcada,
    @Param("idGrupoEstudoHorario") Integer idGrupoEstudoHorario
    ); 

}
