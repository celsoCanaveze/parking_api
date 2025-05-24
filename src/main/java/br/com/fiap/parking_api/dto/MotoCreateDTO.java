package br.com.fiap.parking_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MotoCreateDTO {

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @NotNull
    private Long clienteId;

    @NotNull
    private Long patioId;
}
