package com.example.padrao.repository;

import com.example.padrao.model.Estacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EstacaoRepositoryTest {

    @Autowired
    private EstacaoRepository estacaoRepository;

    @Test
    public void whenFindByNomeCustomQuery_thenReturnEstacao() {
        // when
        Estacao estacao = estacaoRepository.findByNome("Curitiba");

        // then
        assertThat(estacao.getNome()).isEqualTo("Curitiba");
    }
}
