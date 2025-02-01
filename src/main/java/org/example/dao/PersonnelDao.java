package org.example.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.Personnel;

import java.io.Serializable;
import java.util.List;


@RequestScoped
public class PersonnelDao extends GenericDao<Personnel> implements Serializable {

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
}