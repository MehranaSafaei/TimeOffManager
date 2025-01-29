package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Optional;

public abstract class GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public T insert(T entity) {
        try {
            entityManager.persist(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public T update(T entity) {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void delete(long id) {
        try {
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<T> getById(long id) {
        T entity = entityManager.find(entityClass, id);
        return Optional.ofNullable(entity);
    }
}
