package br.com.fiap.parking_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data // gera getters, setters, toString, equals, hashCode automaticamente
@NoArgsConstructor // gera construtor padrão sem argumentos
@AllArgsConstructor // gera construtor com todos os campos
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false, unique = true)
    private String placa;

    private boolean entradaRegistrada;

}
