package com.restaurantefiliais.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Exemplo de um bean genérico que pode ser usado em toda a aplicação
    @Bean
    public String applicationName() {
        return "Sistema de Gestão de Restaurantes";
    }
}