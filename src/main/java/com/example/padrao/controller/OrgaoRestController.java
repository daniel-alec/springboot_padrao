package com.example.padrao.controller;

import com.example.padrao.exception.ResourceNotFoundException;
import com.example.padrao.model.Orgao;
import com.example.padrao.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrgaoRestController {

    @Autowired
    OrgaoRepository orgaoRepository;

    @GetMapping("/orgaos")
    public List<Orgao> getAllEmployees() {
        return orgaoRepository.findAll();
    }

    @GetMapping("/orgaos/{id}")
    public ResponseEntity<Orgao> getEmployeeById(@PathVariable(value = "id") Long orgaoId)
            throws ResourceNotFoundException {
        Orgao orgao = orgaoRepository.findById(orgaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Orgao not found for this id :: " + orgaoId));
        return ResponseEntity.ok().body(orgao);
    }

    /**
     * Test: $ curl --header "Content-Type: application/json" -X POST -d '{"nome":"Inmet"}' http://localhost:8080/padrao/api/orgaos
     *
     * @param orgao
     * @return
     */
    @PostMapping("/orgaos")
    public Orgao createEmployee(@Valid @RequestBody Orgao orgao) {
        return orgaoRepository.save(orgao);
    }
}
