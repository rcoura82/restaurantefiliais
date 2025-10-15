package com.restaurantefiliais.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantefiliais.application.exception.ResourceNotFoundException;
import com.restaurantefiliais.domain.model.Restaurante;
import com.restaurantefiliais.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    // Listar todos os restaurantes
    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    // Buscar restaurante por ID
    public Restaurante buscarPorId(Long id) {
        return restauranteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurante com ID " + id + " não encontrado"));
    }

    // Criar um novo restaurante
    public Restaurante criarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    // Atualizar restaurante
    public Restaurante atualizarRestaurante(Long id, Restaurante restauranteAtualizado) {
        Restaurante restaurante = buscarPorId(id);
        restaurante.setNome(restauranteAtualizado.getNome());
        restaurante.setEndereco(restauranteAtualizado.getEndereco());
        restaurante.setTipoCozinha(restauranteAtualizado.getTipoCozinha());
        restaurante.setHorarioFuncionamento(restauranteAtualizado.getHorarioFuncionamento());
        return restauranteRepository.save(restaurante);
    }

    // Excluir restaurante
    public void excluirRestaurante(Long id) {
        if (!restauranteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Restaurante com ID " + id + " não encontrado");
        }
        restauranteRepository.deleteById(id);
    }
}