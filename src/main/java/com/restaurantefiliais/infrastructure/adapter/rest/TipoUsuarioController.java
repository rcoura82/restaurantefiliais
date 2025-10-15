package com.restaurantefiliais.infrastructure.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantefiliais.application.service.TipoUsuarioService;
import com.restaurantefiliais.domain.model.TipoUsuario;

@RestController
@RequestMapping("/tipos-usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    // Listar todos os tipos de usuários
    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarTodos() {
        return ResponseEntity.ok(tipoUsuarioService.listarTodos());
    }

    // Buscar tipo de usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoUsuarioService.buscarPorId(id));
    }

    // Criar um novo tipo de usuário
    @PostMapping
    public ResponseEntity<TipoUsuario> criarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario novoTipoUsuario = tipoUsuarioService.criarTipoUsuario(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoUsuario);
    }

    // Excluir um tipo de usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTipoUsuario(@PathVariable Long id) {
        tipoUsuarioService.excluirTipoUsuario(id);
        return ResponseEntity.noContent().build();
    }
}