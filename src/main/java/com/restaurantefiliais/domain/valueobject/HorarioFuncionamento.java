package com.restaurantefiliais.domain.valueobject;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class HorarioFuncionamento {

    private String abertura; // Horário de abertura (ex.: "08:00")
    private String fechamento; // Horário de fechamento (ex.: "22:00")

    /**
     * Valida se o horário de funcionamento está correto.
     */
    public void validarHorario() {
        if (abertura == null || fechamento == null) {
            throw new IllegalArgumentException("Horários de abertura e fechamento não podem ser nulos");
        }

        if (!abertura.matches("\\d{2}:\\d{2}") || !fechamento.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Horários devem estar no formato HH:mm");
        }

        if (abertura.compareTo(fechamento) >= 0) {
            throw new IllegalArgumentException("Horário de abertura deve ser anterior ao horário de fechamento");
        }
    }

    @Override
    public String toString() {
        return String.format("De %s às %s", abertura, fechamento);
    }
}