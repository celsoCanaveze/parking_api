package br.com.fiap.parking_api.controller;

import br.com.fiap.parking_api.dto.LoginDTO;
import br.com.fiap.parking_api.dto.UsuarioDTO;
import br.com.fiap.parking_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO login) {
        return ResponseEntity.ok(authService.login(login));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(authService.register(usuarioDTO));
    }
}
