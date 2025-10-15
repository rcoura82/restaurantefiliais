package com.restaurantefiliais.shared.util;

public class StringUtil {

    // Converte uma string para o formato Title Case (ex.: "joão silva" -> "João Silva")
    public static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1))
                         .append(" ");
            }
        }
        return titleCase.toString().trim();
    }

    // Verifica se uma string é nula ou vazia
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}