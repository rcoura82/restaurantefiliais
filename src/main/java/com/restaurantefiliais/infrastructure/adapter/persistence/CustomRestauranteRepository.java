package com.restaurantefiliais.infrastructure.adapter.persistence;

import java.util.List;

import com.restaurantefiliais.domain.model.Restaurante;

public interface CustomRestauranteRepository {
    List<Restaurante> buscarRestaurantesPorTipoCozinha(String tipoCozinha);
}