package com.restaurantefiliais.infrastructure.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurantefiliais.domain.model.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CustomRestauranteRepositoryImpl implements CustomRestauranteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Restaurante> buscarRestaurantesPorTipoCozinha(String tipoCozinha) {
        String jpql = "SELECT r FROM Restaurante r WHERE LOWER(r.tipoCozinha) LIKE LOWER(:tipoCozinha)";
        TypedQuery<Restaurante> query = entityManager.createQuery(jpql, Restaurante.class);
        query.setParameter("tipoCozinha", "%" + tipoCozinha + "%");
        return query.getResultList();
    }
}