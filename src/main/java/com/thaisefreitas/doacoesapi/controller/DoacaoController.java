package com.thaisefreitas.doacoesapi.controller;

import com.thaisefreitas.doacoesapi.model.Doacao;
import com.thaisefreitas.doacoesapi.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
@CrossOrigin(origins = "*")  // Permite chamadas de qualquer origem (importante para o app Android)
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping
    public List<Doacao> listarDoacoes() {
        return doacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doacao> buscarDoacaoPorId(@PathVariable Long id) {
        return doacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Doacao criarDoacao(@RequestBody Doacao doacao) {
        return doacaoService.salvar(doacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doacao> atualizarDoacao(@PathVariable Long id, @RequestBody Doacao doacao) {
        try {
            Doacao atualizada = doacaoService.atualizar(id, doacao);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDoacao(@PathVariable Long id) {
        doacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

