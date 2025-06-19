package br.com.senac.api.controllers;

import br.com.senac.api.entitys.ParquesCientificos;
import br.com.senac.api.useCases.parquesCientificos.ParquesCientificosService;
import br.com.senac.api.useCases.parquesCientificos.domains.ParquesCientificosRequestDom;
import br.com.senac.api.useCases.parquesCientificos.domains.ParquesCientificosResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ParquesCientificos")
@CrossOrigin

public class ParquesCientificosController {

    @Autowired
    private ParquesCientificosService parqueCientificoService;

    @PostMapping("/criar")
    public ResponseEntity<ParquesCientificosResponseDom> criarParqueCientifico(@RequestBody ParquesCientificosRequestDom parqueCientifico) throws Exception {
        ParquesCientificosResponseDom response = parqueCientificoService.criarParquesCientificos(parqueCientifico);

        return ResponseEntity.status(201).body(response);

    }


    @GetMapping("/carregar")
    public ResponseEntity<List<ParquesCientificosResponseDom>> carregarParquesCientificos(){
        List<ParquesCientificosResponseDom> response = parqueCientificoService.carregarParquesCientificos();

        if(response.isEmpty()){
            return ResponseEntity.status(204).body(null);
        }

        return ResponseEntity.ok(response);

    }


    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletarParqueCientifico(@PathVariable Long id) {
        boolean response = parqueCientificoService.excluirParqueCientifico(id);

        if (response) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.badRequest().body(null);

    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ParquesCientificosResponseDom> atualizarCentroInovacao(@PathVariable Long id, @RequestBody ParquesCientificosRequestDom centroInovacao) throws Exception {
        ParquesCientificosResponseDom response = parqueCientificoService.atualizarParqueCientifico(id, centroInovacao);

        return ResponseEntity.ok(response);

    }


    @GetMapping("/carregar/{id}")
    public ResponseEntity<ParquesCientificos> carregarCentroEspecifico(@PathVariable Long id) throws Exception{

        ParquesCientificos response = parqueCientificoService.carregarParqueEspecifico(id);

        return ResponseEntity.ok(response);
    }




}
