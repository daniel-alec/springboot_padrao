package com.example.padrao.controller;

import com.example.padrao.domain.DataTableResultInfo;
import com.example.padrao.model.Estacao;
import com.example.padrao.service.EstacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estacoes")
public class EstacaoController {
    @Autowired
    private EstacaoService estacaoService;

    @GetMapping("/data")
    public ResponseEntity getAllEstacoes(
            @RequestParam(value = "start", required = false, defaultValue="0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue="10") Integer length,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw,
            @RequestParam(defaultValue = "id") String sortBy) {

        int pageNo = (start)/(length+1);
        Page<Estacao> pageInfo = estacaoService.getAllEstacoes(pageNo, length, sortBy);

        DataTableResultInfo dataTableResultInfo = new DataTableResultInfo();
        dataTableResultInfo.setData(pageInfo);
        dataTableResultInfo.setDraw(draw);
        dataTableResultInfo.setLength(length);
        dataTableResultInfo.setRecordsTotal(pageInfo.getNumberOfElements());
        dataTableResultInfo.setRecordsFiltered(pageInfo.getNumberOfElements());

        return ResponseEntity.ok(dataTableResultInfo);
    }
}
