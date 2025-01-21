package org.example.dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.controller.request.CreateRequestDto;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.mapper.DtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonnelDAO {

    @Inject
    private EntityManager entityManager;

    public PersonnelDAO() {}

    public void createPersonnel(Personnel personnel) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(personnel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Personnel getPersonnelById(Long id) {
        Personnel personnel = null;
        try {
            personnel = entityManager.find(Personnel.class, id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return personnel;
    }

    public List<Personnel> getAllPersonnel() {
       try {
           List<Personnel> personnelList = entityManager.createNamedQuery("selectAll").getResultList();
           return personnelList;
       }catch (Exception e) {
           e.printStackTrace();
       }
       return null;
    }






//    public PersonnelDTO createPersonnel(PersonnelDTO personnel) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(personnel);
//        entityManager.getTransaction().commit();
//        return personnel;
//    }
//    public PersonnelDTO registerPersonnel(RegisterRequest registerRequest) {
//        Personnel personnel = new Personnel();
//        personnel.setUsername(registerRequest.getUsername());
//        personnel.setPassword(registerRequest.getPassword());
//        entityManager.persist(personnel);
//        return DtoMapper.personnelDTO(personnel);
//    }
}
