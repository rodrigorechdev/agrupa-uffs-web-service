package br.com.agrupauffs.grupo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QueryCurso extends CrudRepository<EntidadeCurso, Integer> {
	
	@Query(value = "select * from curso", nativeQuery = true)
	List<EntidadeCurso> consultaCursos(); 
}
