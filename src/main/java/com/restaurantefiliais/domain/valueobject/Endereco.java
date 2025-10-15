package com.restaurantefiliais.domain.valueobject;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @Override
    public String toString() {
        return String.format("%s, %s%s, %s - %s, %s, %s",
                rua,
                numero,
                complemento != null && !complemento.isEmpty() ? " (" + complemento + ")" : "",
                bairro,
                cidade,
                estado,
                cep
        );
    }
}