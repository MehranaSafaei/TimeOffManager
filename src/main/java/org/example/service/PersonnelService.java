package org.example.service;

<<<<<<< HEAD
import org.example.dao.PersonnelDAO;
import org.example.entity.dto.PersonnelDTO;

public class PersonnelService {

    private PersonnelDAO personnelDAO;

     public PersonnelDTO createPersonnel(PersonnelDTO personnelDTO) {
         return personnelDAO.createPersonnel(personnelDTO);
     }
=======
import org.example.controller.request.CreateRequestDto;
import org.example.dao.PersonnelDAO;
import org.example.entity.dto.PersonnelDTO;

import java.util.List;

public class PersonnelService {

    private PersonnelDAO personnelDAO;
    public PersonnelService(PersonnelDAO personnelDAO) {}


    public PersonnelDTO createPersonnel(CreateRequestDto createRequest) {//is problem for enter (PersonnelDTO personnelDTO)
        //call the build object method
        return personnelDAO.createPersonnel(person);
    }

    public PersonnelDTO getPersonnelById(Long id) {
        return personnelDAO.getPersonnelById(id);
    }

    public List<PersonnelDTO> getAllPersonnel() {
        return personnelDAO.getAllPersonnel();
    }

    //TODO:canSave-canDelete-canEdit

    //TODO:mapper builder-->Object personel


>>>>>>> e74cd717d7efe345d80116be7a6bb409270b5f0c
}
