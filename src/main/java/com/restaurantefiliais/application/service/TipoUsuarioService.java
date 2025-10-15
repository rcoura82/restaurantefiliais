package com.restaurantefiliais.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantefiliais.application.exception.ResourceNotFoundException;
import com.restaurantefiliais.domain.model.TipoUsuario;
import com.restaurantefiliais.domain.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    // Listar todos os tipos de usuários
    public List<TipoUsuario> listarTodos() {
        return tipoUsuarioRepository.findAll();
    }

    // Buscar tipo de usuário por ID
    public TipoUsuario buscarPorId(Long id) {
        return tipoUsuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo de usuário com ID " + id + " não encontrado"));
    }

    // Criar um novo tipo de usuário
    public TipoUsuario criarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    // Excluir um tipo de usuário
    public void excluirTipoUsuario(Long id) {
        if (!tipoUsuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tipo de usuário com ID " + id + " não encontrado");
        }
        tipoUsuarioRepository.deleteById(id);
    }
}