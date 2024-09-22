package br.com.senac.api.controllers;

import br.com.senac.api.entitys.Coworkings;
import br.com.senac.api.entitys.ParquesCientificos;
import br.com.senac.api.useCases.centrosInovacao.domains.CentrosInovacaoRequestDom;
import br.com.senac.api.useCases.centrosInovacao.domains.CentrosInovacaoResponseDom;
import br.com.senac.api.useCases.coworkings.CoworkingsService;
import br.com.senac.api.useCases.coworkings.domains.CoworkingsRequestDom;
import br.com.senac.api.useCases.coworkings.domains.CoworkingsResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Coworkings")
@CrossOrigin

public class CoworkingsController {

    @Autowired
    private CoworkingsService coworkingsService;

    @PostMapping("/criar")
    public ResponseEntity<CoworkingsResponseDom> criarCoworking(@RequestBody CoworkingsRequestDom coworking) throws Exception {
        CoworkingsResponseDom response = coworkingsService.criarCoworking(coworking);

        return ResponseEntity.status(201).body(response);

    }


    @GetMapping("/carregar")
    public ResponseEntity<List<CoworkingsResponseDom>> carregarCoworkings(){
        List<CoworkingsResponseDom> response = coworkingsService.carregarCoworkings();

        if(response.isEmpty()){
            return ResponseEntity.status(204).body(null);
        }

        return ResponseEntity.ok(response);

    }


    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletarCoworking(@PathVariable Long id) {
        boolean response = coworkingsService.excluirCoworking(id);

        if (response) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.badRequest().body(null);

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CoworkingsResponseDom> atualizarCoworking(@PathVariable Long id, @RequestBody CoworkingsRequestDom coworking) throws Exception {
        CoworkingsResponseDom response = coworkingsService.atualizarCoworking(id, coworking);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/carregar/{id}")
    public ResponseEntity<Coworkings> carregarCoworkingEspecifico(@PathVariable Long id) throws Exception{

        Coworkings response = coworkingsService.carregarCoworking(id);

        return ResponseEntity.ok(response);
    }




}
