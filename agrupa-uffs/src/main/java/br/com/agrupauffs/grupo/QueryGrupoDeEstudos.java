package br.com.agrupauffs.grupo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * To do*/
public interface QueryGrupoDeEstudos extends CrudRepository<EntidadeGrupoDeEstudos, Integer> {
	
	@Query(value = "select * from grupo_estudo", nativeQuery = true)
	List<EntidadeGrupoDeEstudos> consultaGrupoDeEstudos(); 
	
}
