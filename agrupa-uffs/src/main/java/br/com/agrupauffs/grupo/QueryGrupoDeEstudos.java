package br.com.agrupauffs.grupo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * To do*/
public interface QueryGrupoDeEstudos {
	
	@Query(value = "query")
	List<EntidadeGrupoDeEstudos> consultaGrupoDeEstudos(Integer idGrupo); 
	
}
