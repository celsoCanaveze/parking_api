package br.com.fiap.parking_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatioDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;
}
