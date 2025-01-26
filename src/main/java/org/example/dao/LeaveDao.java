package org.example.dao;

import org.example.entity.Leave;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.Personnel;

import java.util.List;
import java.util.Optional;

public class LeaveDao extends GenericDao<Leave> {

    @PersistenceContext
    private EntityManager entityManager;

    public LeaveDao() {
        super(Leave.class);
    }
//
//    @Override
//    @Transactional
//    public Optional<Leave> insert(Leave entity) {
//        entityManager.persist(entity);
//        return Optional.of(entity);
//    }

    @Override
    @Transactional
    public Leave update(Leave entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Leave entity = entityManager.find(Leave.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<Leave> findAll() {
        return entityManager.createNamedQuery("selectAll").getResultList();
    }
}
