package br.com.agrupauffs.usuario;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryPerfilCursosInteresse extends CrudRepository<EntidadeUsuarioCursos, Integer> {
    
    @Transactional
    @Modifying
    @Query(value = "insert into usuario_perfil_cursos_interesse (id_usuario, id_curso) values (:idUsuario, :idCurso)", nativeQuery = true)
    public void insere(@Param("idUsuario") int idGrupo, @Param("idCurso") int idUsuario); 

    @Transactional
    @Modifying
    @Query(value = "delete from usuario_perfil_cursos_interesse where id_usuario_perfil_cursos_interesse = :id", nativeQuery = true)
    public void deleta(@Param("id") int idUsuarioPerfilCursosInteresse); 

    @Transactional
    @Modifying
    @Query(value = "update usuario_perfil_cursos_interesse set id_usuario = :idUsuario, id_curso = :idCurso where id_usuario_perfil_cursos_interesse = :id", nativeQuery = true)
    public void atualiza(@Param("idUsuario") int idGrupo, @Param("idCurso") int idUsuario, @Param("id") int idUsuarioPerfilCursosInteresse); 
   
}
