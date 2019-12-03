package com.example.padrao.controller;

import com.example.padrao.domain.DataTableResultInfo;
import com.example.padrao.model.Estacao;
import com.example.padrao.service.EstacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class EstacaoController {
    @Autowired
    private EstacaoService estacaoService;

    @GetMapping("/estacoes")
    public String estacoesPage(HttpServletRequest request, Model model) {

        return "estacoes";
    }

    @GetMapping("/estacoes/data")
    public ResponseEntity getAllEstacoes(
            HttpServletRequest request,
            @RequestParam(value = "start", required = false, defaultValue="0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue="10") Integer length,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw,
            @RequestParam(defaultValue = "id") String sortBy) {

        Map map = request.getParameterMap();
        for (Object key: map.keySet())
        {
            String keyStr = (String)key;
            String[] value = (String[])map.get(keyStr);
            System.out.println("Key" + (String)key + "   :   " + Arrays.toString(value));
        }

        int pageNo = (start)/(length+1);
        Page<Estacao> pageInfo = estacaoService.getAllEstacoes(pageNo, length, sortBy);

        DataTableResultInfo dataTableResultInfo = new DataTableResultInfo();
        dataTableResultInfo.setData(pageInfo);
        dataTableResultInfo.setDraw(draw);
        dataTableResultInfo.setRecordsTotal(pageInfo.getNumberOfElements());
        dataTableResultInfo.setRecordsFiltered(pageInfo.getNumberOfElements());

        return ResponseEntity.ok(dataTableResultInfo);
    }

}
