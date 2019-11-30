package com.example.padrao.repository;

import com.example.padrao.model.Estacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EstacaoRepositoryTest {

    @Autowired
    private EstacaoRepository estacaoRepository;

    @Test
    public void whenFindByNomeCustomQuery_thenReturnEstacao() {
        // when
        Estacao estacao = estacaoRepository.findByNomeNativeQuery("Curitiba");

        System.out.println(estacao);

        // then
        assertThat(estacao.getNome()).isEqualTo("Curitiba");
    }

    @Test
    public void testFindAll() {
        List<Estacao> estacoes = estacaoRepository.findAll();
        estacoes.forEach(estacao -> System.out.println(estacao.toString()));
    }

    @Test
    public void testFindAll_Pageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
        Page<Estacao> estacoes = estacaoRepository.findAll(pageable);
        System.out.println(estacoes.toString());
    }
}
