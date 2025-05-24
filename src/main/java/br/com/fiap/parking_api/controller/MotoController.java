package br.com.fiap.parking_api.controller;

import br.com.fiap.parking_api.dto.MotoDTO;
import br.com.fiap.parking_api.service.MotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;

    @GetMapping
    public ResponseEntity<List<MotoDTO>> listar() {
        return ResponseEntity.ok(motoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MotoDTO> cadastrar(@RequestBody @Valid MotoDTO dto) {
        return ResponseEntity.ok(motoService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MotoDTO dto) {
        return ResponseEntity.ok(motoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        motoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/entrada")
    public ResponseEntity<MotoDTO> registrarEntrada(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.registrarEntrada(id));
    }
}
