package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.mapper.DtoMapper;

public class PersonnelDAO {

    private EntityManager entityManager;
    private DtoMapper mapper;

    public PersonnelDAO() {}

    public Personnel createPersonnel(PersonnelDTO personnelDTO) {
        Personnel personnel = mapper.personnel(personnelDTO);
        entityManager.persist(personnel);
        return mapper.personnelDTO(personnel);
    }

//    public PersonnelDTO createPersonnel(PersonnelDTO personnel) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(personnel);
//        entityManager.getTransaction().commit();
//        return personnel;
//    }
}
