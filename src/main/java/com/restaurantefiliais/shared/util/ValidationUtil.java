package com.restaurantefiliais.shared.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String TIME_REGEX = "^\\d{2}:\\d{2}$";

    // Valida se um e-mail é válido
    public static boolean isValidEmail(String email) {
        return email != null && Pattern.matches(EMAIL_REGEX, email);
    }

    // Valida se um horário está no formato HH:mm
    public static boolean isValidTime(String time) {
        return time != null && Pattern.matches(TIME_REGEX, time);
    }

    // Verifica se uma string não está vazia ou nula
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}