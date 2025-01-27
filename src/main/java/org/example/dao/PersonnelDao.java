package org.example.dao;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import org.example.entity.Personnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class PersonnelDao extends GenericDao<Personnel> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    public PersonnelDao() {
        super(Personnel.class);
    }


    @Override
    public void insert(Personnel entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public List findAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            return entityManager.createNamedQuery("selectAll").getResultList();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }



//    public PersonnelDao() {
//        super(Personnel.class);
//    }
//
//    @Override
//    @Transactional
//    public Optional<Personnel> insert(Personnel entity) {
//        try {
//            entityManager.persist(entity);
//            return Optional.of(entity);
//        }catch (Exception e) {
//          e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    @Transactional
//    public Personnel update(Personnel entity) {
//        return entityManager.merge(entity);
//    }
//
//    @Override
//    @Transactional
//    public void delete(long id) {
//        Personnel entity = entityManager.find(Personnel.class, id);
//        if (entity != null) {
//            entityManager.remove(entity);
//        }
//    }
//
//    public List<Personnel> findAll() {
//        return entityManager.createNamedQuery("selectAll").getResultList();
//    }
}
