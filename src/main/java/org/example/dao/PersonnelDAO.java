package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.mapper.DtoMapper;

public class PersonnelDAO {

    private EntityManager entityManager;

    public PersonnelDAO() {}

    public PersonnelDTO createPersonnel(PersonnelDTO personnelDTO) {
        Personnel personnel = DtoMapper.personnel(personnelDTO);
        entityManager.persist(personnel);
        return DtoMapper.personnelDTO(personnel);
    }

//    public PersonnelDTO createPersonnel(PersonnelDTO personnel) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(personnel);
//        entityManager.getTransaction().commit();
//        return personnel;
//    }
}
