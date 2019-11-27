package com.example.padrao.repository;

import com.example.padrao.model.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Integer> {
    List<Orgao> findByNome(String nome);
}
