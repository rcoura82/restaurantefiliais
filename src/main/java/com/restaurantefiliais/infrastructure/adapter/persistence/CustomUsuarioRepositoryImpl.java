package com.restaurantefiliais.infrastructure.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurantefiliais.domain.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CustomUsuarioRepositoryImpl implements CustomUsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> buscarUsuariosPorNome(String nome) {
        String jpql = "SELECT u FROM Usuario u WHERE LOWER(u.nome) LIKE LOWER(:nome)";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}