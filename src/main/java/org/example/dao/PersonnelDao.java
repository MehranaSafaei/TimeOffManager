package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.Personnel;

import java.util.List;



public class PersonnelDao extends GenericDao<Personnel> {

   /* public long countPersonnelByID;*/

    @PersistenceContext(unitName = "leaveManagement")
    private EntityManager entityManager;

    public PersonnelDao() {
        super(Personnel.class);
    }

    public List<Personnel> findAll() {
        try {
            return entityManager.createNamedQuery("selectAll", Personnel.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void create(Personnel entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting personnel: " + e.getMessage());
        }
    }

   /* public long countPersonnelByCode(long personnelCode) {
        try {
            return entityManager.createNamedQuery("?", Long.class)
                    .setParameter("personnelCode", personnelCode).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }*/
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

