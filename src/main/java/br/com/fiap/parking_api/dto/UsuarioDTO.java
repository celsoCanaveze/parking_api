package br.com.fiap.parking_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
