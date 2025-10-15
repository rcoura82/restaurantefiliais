package com.restaurantefiliais.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantefiliais.application.exception.ResourceNotFoundException;
import com.restaurantefiliais.domain.model.ItemCardapio;
import com.restaurantefiliais.domain.repository.ItemCardapioRepository;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    // Listar todos os itens do cardápio
    public List<ItemCardapio> listarTodos() {
        return itemCardapioRepository.findAll();
    }

    // Buscar item do cardápio por ID
    public ItemCardapio buscarPorId(Long id) {
        return itemCardapioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item do cardápio com ID " + id + " não encontrado"));
    }

    // Criar um novo item do cardápio
    public ItemCardapio criarItemCardapio(ItemCardapio itemCardapio) {
        return itemCardapioRepository.save(itemCardapio);
    }

    // Atualizar item do cardápio
    public ItemCardapio atualizarItemCardapio(Long id, ItemCardapio itemAtualizado) {
        ItemCardapio item = buscarPorId(id);
        item.setNome(itemAtualizado.getNome());
        item.setDescricao(itemAtualizado.getDescricao());
        item.setPreco(itemAtualizado.getPreco());
        item.setDisponivelSomenteNoLocal(itemAtualizado.getDisponivelSomenteNoLocal());
        item.setCaminhoFoto(itemAtualizado.getCaminhoFoto());
        return itemCardapioRepository.save(item);
    }

    // Excluir item do cardápio
    public void excluirItemCardapio(Long id) {
        if (!itemCardapioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Item do cardápio com ID " + id + " não encontrado");
        }
        itemCardapioRepository.deleteById(id);
    }
}