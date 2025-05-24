package br.com.fiap.parking_api.controller;

import br.com.fiap.parking_api.dto.PatioDTO;
import br.com.fiap.parking_api.service.PatioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patios")
@RequiredArgsConstructor
public class PatioController {

    private final PatioService patioService;

    @GetMapping
    public ResponseEntity<List<PatioDTO>> listar() {
        return ResponseEntity.ok(patioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(patioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PatioDTO> cadastrar(@RequestBody @Valid PatioDTO dto) {
        return ResponseEntity.ok(patioService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PatioDTO dto) {
        return ResponseEntity.ok(patioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        patioService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
