package com.restaurantefiliais.infrastructure.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantefiliais.application.service.ItemCardapioService;
import com.restaurantefiliais.domain.model.ItemCardapio;

@RestController
@RequestMapping("/itens-cardapio")
public class ItemCardapioController {

    @Autowired
    private ItemCardapioService itemCardapioService;

    // Listar todos os itens do cardápio
    @GetMapping
    public ResponseEntity<List<ItemCardapio>> listarTodos() {
        return ResponseEntity.ok(itemCardapioService.listarTodos());
    }

    // Buscar item do cardápio por ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemCardapio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemCardapioService.buscarPorId(id));
    }

    // Criar um novo item do cardápio
    @PostMapping
    public ResponseEntity<ItemCardapio> criarItemCardapio(@RequestBody ItemCardapio itemCardapio) {
        ItemCardapio novoItem = itemCardapioService.criarItemCardapio(itemCardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    // Atualizar um item do cardápio existente
    @PutMapping("/{id}")
    public ResponseEntity<ItemCardapio> atualizarItemCardapio(@PathVariable Long id, @RequestBody ItemCardapio itemCardapio) {
        ItemCardapio itemAtualizado = itemCardapioService.atualizarItemCardapio(id, itemCardapio);
        return ResponseEntity.ok(itemAtualizado);
    }

    // Excluir um item do cardápio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirItemCardapio(@PathVariable Long id) {
        itemCardapioService.excluirItemCardapio(id);
        return ResponseEntity.noContent().build();
    }
}