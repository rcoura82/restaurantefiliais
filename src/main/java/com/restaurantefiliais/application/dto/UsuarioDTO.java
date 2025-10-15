package com.restaurantefiliais.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String login;
    private String tipoUsuario; // Nome do tipo de usuário (ex.: "Dono de Restaurante", "Cliente")
    private String endereco; // Endereço formatado como String
}