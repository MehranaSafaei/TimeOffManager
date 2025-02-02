package org.example.dao;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Optional;

//@Dependent
public class GenericDao<T> {

    @PersistenceContext(unitName = "PersonnelUnit")
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    @Inject
    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public void create(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T update(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;
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
