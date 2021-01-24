package br.com.agrupauffs.usuario;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QueryUsuario extends CrudRepository<EntidadeUsuario, Integer> {
    
    @Query(value = "select * from usuario where id_usuario = :idUsuario", nativeQuery = true)
    public EntidadeUsuario consultaUsuarioPorId(@Param("idUsuario") int idUsuario); 

    @Query(value = "select * from usuario where email = :email", nativeQuery = true)
    public EntidadeUsuario consultaUsuarioPorEmail(@Param("email") String email); 

    @Transactional
	@Modifying
    @Query(value = "insert into usuario (cd_usuario, senha, email, nome, endereco, descricao) values (:cdUsuario, :senha, :email, :nome, :endereco, :descricao)", nativeQuery = true)
    public void insere(@Param("cdUsuario") String cdUsuario, @Param("senha") String senha, @Param("email") String email,
    @Param("nome") String nome, @Param("endereco") String endereco, @Param("descricao") String descricao); 

    @Transactional
	@Modifying
    @Query(value = "delete from usuario where id_usuario = :id", nativeQuery = true)
    public void deleta(@Param("id") int id); 

    @Transactional
	@Modifying
    @Query(value = "update usuario set cd_usuario = :cdUsuario, senha = :senha, email = :email, nome = :nome, endereco = :endereco, descricao = :descricao where id_usuario = :idUsuario ", nativeQuery = true)
    public void atualiza(@Param("cdUsuario") String cdUsuario, @Param("senha") String senha, @Param("email") String email,
    @Param("nome") String nome, @Param("endereco") String endereco, @Param("descricao") String descricao, @Param("idUsuario") int idUsuario); 



}
