package com.example.padrao.controller;

import com.example.padrao.exception.ResourceNotFoundException;
import com.example.padrao.model.Orgao;
import com.example.padrao.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class OrgaoRestController {

    @Autowired
    OrgaoRepository orgaoRepository;

    /**
     * curl  -X GET  http://localhost:8080/padrao/api/orgaos
     * @return
     */
    @GetMapping("/orgaos")
    public List<Orgao> getAllEmployees() {
        return orgaoRepository.findAll();
    }

    /**
     * curl  -X GET  http://localhost:8080/padrao/api/orgaos/1
     * @param orgaoId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/orgaos/{id}")
    public ResponseEntity<Orgao> getEmployeeById(@PathVariable(value = "id") Integer orgaoId)
            throws ResourceNotFoundException {
        Orgao orgao = orgaoRepository.findById(orgaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Orgao not found for this id " + orgaoId));
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

    /**
     * curl --header "Content-Type: application/json" -X PUT -d '{"nome":"Iapar2"}' http://localhost:8080/padrao/api/orgaos/7
     * @param orgaoId
     * @param orgaoRequest
     * @return
     */
    @PutMapping("/orgaos/{orgaoId}")
    public Orgao updateOrgao(@PathVariable Integer orgaoId,
                             @Valid @RequestBody Orgao orgaoRequest) {
        return orgaoRepository.findById(orgaoId)
                .map(orgao -> {
                    orgao.setNome(orgaoRequest.getNome());
                    return orgaoRepository.save(orgao);
                }).orElseThrow(() -> new ResourceNotFoundException("Orgao not found with id " + orgaoId));
    }

    /**
     * curl -X DELETE http://localhost:8080/padrao/api/orgaos/7
     * @param orgaoId
     * @return
     */
    @DeleteMapping("/orgaos/{orgaoId}")
    public ResponseEntity<?> deleteOrgao(@PathVariable Integer orgaoId) {
        return orgaoRepository.findById(orgaoId)
                .map(orgao -> {
                    orgaoRepository.delete(orgao);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Orgao not found with id " + orgaoId));
    }
}
