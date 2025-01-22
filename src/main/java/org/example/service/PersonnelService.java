package org.example.service;

import org.example.dao.PersonnelDAO;
import org.example.entity.dto.PersonnelDTO;

public class PersonnelService {

    private PersonnelDAO personnelDAO;

     public PersonnelDTO createPersonnel(PersonnelDTO personnelDTO) {
         return personnelDAO.createPersonnel(personnelDTO);
     }
}
