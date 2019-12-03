package com.example.padrao.service;

import com.example.padrao.model.Estacao;
import com.example.padrao.repository.EstacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EstacaoService {

    @Autowired
    EstacaoRepository estacaoRepository;

    public Page<Estacao> getAllEstacoes(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Estacao> page = estacaoRepository.findAll(pageable);

        return page;
    }

}