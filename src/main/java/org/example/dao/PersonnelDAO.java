package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.controller.request.CreateRequestDto;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.mapper.DtoMapper;

import java.util.List;
import java.util.stream.Collectors;


public class PersonnelDAO {

    private EntityManager entityManager;

    public PersonnelDAO() {}

    public PersonnelDTO createPersonnel(CreateRequestDto createRequest) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(DtoMapper.personnel(createRequest));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PersonnelDTO getPersonnelById(Long id) {
        return DtoMapper.personnelDTO(entityManager.find(Personnel.class, id));
    }

    public List<PersonnelDTO> getAllPersonnel() {
       try {
           List<Personnel> personnelList = entityManager.createNamedQuery("Personnel.findAll").getResultList();
           return personnelList.stream()
//                 .map(personnel -> DtoMapper.personnelDTO(personnel))
                   .map(DtoMapper :: personnelDTO)
                   .collect(Collectors.toList());
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
