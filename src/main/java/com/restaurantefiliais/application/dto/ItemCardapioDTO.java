package com.restaurantefiliais.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Boolean disponivelSomenteNoLocal;
    private String caminhoFoto;
    private Long restauranteId; // ID do restaurante ao qual o item pertence
}