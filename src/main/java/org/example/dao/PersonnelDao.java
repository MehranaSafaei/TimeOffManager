package org.example.dao;

import org.example.entity.Personnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class PersonnelDao extends GenericDao<Personnel> {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonnelDao() {
        super(Personnel.class);
    }

    @Override
    @Transactional
    public Optional<Personnel> insert(Personnel entity) {
        entityManager.persist(entity);
        return Optional.of(entity);
    }

    @Override
    @Transactional
    public Personnel update(Personnel entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Personnel entity = entityManager.find(Personnel.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<Personnel> findAll() {
        return entityManager.createNamedQuery("selectAll").getResultList();
    }
}
