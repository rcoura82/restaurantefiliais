package com.restaurantefiliais.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurantefiliais.application.exception.BusinessException;
import com.restaurantefiliais.domain.model.Usuario;
import com.restaurantefiliais.domain.repository.UsuarioRepository;

@Component
public class AuthenticationManager {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método para autenticar um usuário com base no login e senha
    public Usuario authenticate(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new BusinessException("Usuário ou senha inválidos"));

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            throw new BusinessException("Usuário ou senha inválidos");
        }

        return usuario;
    }
}