package com.restaurantefiliais.application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantefiliais.application.exception.BusinessException;
import com.restaurantefiliais.application.exception.ResourceNotFoundException;
import com.restaurantefiliais.domain.model.Usuario;
import com.restaurantefiliais.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar um novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        usuario.setDataUltimaAlteracao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    // Atualizar os dados de um usuário existente
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado"));
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setLogin(usuarioAtualizado.getLogin());
        usuario.setEndereco(usuarioAtualizado.getEndereco());
        usuario.setDataUltimaAlteracao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    // Trocar a senha do usuário
    public void trocarSenha(Long id, String senhaAtual, String novaSenha, String confirmacaoSenha) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado"));

        if (!usuario.getSenha().equals(senhaAtual)) {
            throw new BusinessException("Senha atual incorreta");
        }

        if (!novaSenha.equals(confirmacaoSenha)) {
            throw new BusinessException("Nova senha e confirmação não coincidem");
        }

        usuario.setSenha(novaSenha);
        usuario.setDataUltimaAlteracao(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }

    // Validar login do usuário
    public Usuario validarLogin(String login, String senha) {
        return usuarioRepository.findByLogin(login)
            .filter(usuario -> usuario.getSenha().equals(senha))
            .orElseThrow(() -> new BusinessException("Credenciais inválidas"));
    }

    // Buscar usuário por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado"));
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Excluir um usuário
    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário com ID " + id + " não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}