package com.restaurantefiliais.infrastructure.adapter.persistence;

import java.util.List;

import com.restaurantefiliais.domain.model.Usuario;

public interface CustomUsuarioRepository {
    List<Usuario> buscarUsuariosPorNome(String nome);
}