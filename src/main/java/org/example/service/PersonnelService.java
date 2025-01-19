package org.example.service;

import org.example.controller.request.CreateRequestDto;
import org.example.dao.PersonnelDAO;
import org.example.entity.dto.PersonnelDTO;

public class PersonnelService {

    private PersonnelDAO personnelDAO;
    public PersonnelService(PersonnelDAO personnelDAO) {}


    public PersonnelDTO createPersonnel(CreateRequestDto createRequest) {  //is problem for enter (PersonnelDTO personnelDTO)
        return personnelDAO.createPersonnel(createRequest);
    }
}
