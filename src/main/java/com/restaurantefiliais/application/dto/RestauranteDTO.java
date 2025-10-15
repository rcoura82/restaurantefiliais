package com.restaurantefiliais.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteDTO {

    private Long id;
    private String nome;
    private String endereco; // Endereço formatado como String
    private String tipoCozinha;
    private String horarioFuncionamento;
    private Long donoId; // ID do dono do restaurante
}