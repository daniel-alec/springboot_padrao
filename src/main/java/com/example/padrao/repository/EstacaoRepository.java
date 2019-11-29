package com.example.padrao.repository;

import com.example.padrao.model.Estacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacaoRepository extends JpaRepository<Estacao, Integer> {
    Estacao findByNome(String nome);

    // Custom JPQL Queries with @Query
    @Query("select e from Estacao e where e.nome = :nome")
    Estacao findByNomeCustomQuery(@Param("nome") String nome);

    // Another Native Query
    @Query(
            value = "select * from estacao as e where e.nome = :nome",
            nativeQuery = true)
    Estacao findByNomeNativeQuery(@Param("nome") String nome);
}
