package br.com.agrupauffs.grupo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryGrupoDeEstudos extends CrudRepository<EntidadeGrupoDeEstudos, Integer> {
	
	@Query(value = "select * from grupo_estudo where id_grupo_estudo = :id", nativeQuery = true)
	EntidadeGrupoDeEstudos consultaGrupoDeEstudosPorId(@Param("id") int id); 
	
	@Query(value = "select * from grupo_estudo where nm_grupo like %:pesquisa%", nativeQuery = true)
	List<EntidadeGrupoDeEstudos> consultaGrupoDeEstudosPorPesquisa(@Param("pesquisa") String pesquisa); 

	@Query(value = "select * from grupo_estudo", nativeQuery = true)
	List<EntidadeGrupoDeEstudos> consultaGrupoDeEstudos(); 

	@Query(value = "select * from grupo_estudo_curso gec join grupo_estudo ge on gec.id_grupo_estudo = ge.id_grupo_estudo join curso c on gec.id_curso = c.id_curso where c.id_curso = :curso", nativeQuery = true)
	List<EntidadeGrupoDeEstudos> consultaGrupoDeEstudosCurso(@Param("curso") String idCurso); 
	
	@Query(value = "select * from grupo_estudo as ge join grupo_estudo_usuario as ges on ge.id_grupo_estudo = ges.id_grupo_estudo where pedido_pendente = true and ge.id_grupo_estudo = :idGrupo", nativeQuery = true)
	EntidadeGrupoDeEstudos consultaGrupoDeEstudoEspecifico(@Param("idGrupo") int idGrupo); 
}
