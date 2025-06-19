package br.com.senac.api.controllers;

import br.com.senac.api.entitys.CentrosInovacao;
import br.com.senac.api.entitys.ParquesCientificos;
import br.com.senac.api.useCases.centrosInovacao.CentrosInovacaoService;
import br.com.senac.api.useCases.centrosInovacao.domains.CentrosInovacaoRequestDom;
import br.com.senac.api.useCases.centrosInovacao.domains.CentrosInovacaoResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CentrosInovacao")
@CrossOrigin

public class CentrosInovacaoController {

    @Autowired
    private CentrosInovacaoService centrosInovacaoService;

    @PostMapping("/criar")
    public ResponseEntity<CentrosInovacaoResponseDom> criarCentroInovacao(@RequestBody CentrosInovacaoRequestDom centroInovacao) throws Exception {
        CentrosInovacaoResponseDom response = centrosInovacaoService.criarCentroInovacao(centroInovacao);

        return ResponseEntity.status(201).body(response);

    }


    @GetMapping("/carregar")
    public ResponseEntity<List<CentrosInovacaoResponseDom>> carregarCentrosInovacao(){
        List<CentrosInovacaoResponseDom> response = centrosInovacaoService.carregarCentrosInovacao();

        if(response.isEmpty()){
            return ResponseEntity.status(204).body(null);
        }

        return ResponseEntity.ok(response);

    }


    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletarCentroInovacao(@PathVariable Long id) {
        boolean response = centrosInovacaoService.excluirCentroInovacao(id);

        if (response) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.badRequest().body(null);

    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CentrosInovacaoResponseDom> atualizarCentroInovacao(@PathVariable Long id, @RequestBody CentrosInovacaoRequestDom centroInovacao) throws Exception {
        CentrosInovacaoResponseDom response = centrosInovacaoService.atualizarCentroInovacao(id, centroInovacao);

        return ResponseEntity.ok(response);

    }


    @GetMapping("/carregar/{id}")
    public ResponseEntity<CentrosInovacao> carregarCentroEspecifico(@PathVariable Long id) throws Exception{

        CentrosInovacao response = centrosInovacaoService.carregarCentroInovacao(id);

        return ResponseEntity.ok(response);
    }




}
