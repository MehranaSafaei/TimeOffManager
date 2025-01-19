package org.example.mapper;

import org.example.controller.request.CreateRequestDto;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;

public class DtoMapper {

    public static PersonnelDTO personnelDTO(Personnel personnel) {
        if (personnel == null) {
            return null;
        }
        PersonnelDTO personnelDTO = new PersonnelDTO();
        personnelDTO.setId(personnel.getId());
        personnelDTO.setFirstName(personnel.getFirstName());
        personnelDTO.setLastName(personnel.getLastName());
        personnelDTO.setPassword(personnel.getPassword());
        personnelDTO.setEmail(personnel.getEmail());
        personnelDTO.setPersonnelCode(personnel.getPersonnelCode());
        return personnelDTO;
    }

    public static Personnel personnel(CreateRequestDto createRequestDto) {
        if (createRequestDto == null) {
            return null;
        }
        Personnel personnel = new Personnel();

        personnel.setPersonnelCode(createRequestDto.getPersonnelCode());
        personnel.setMobile(createRequestDto.getMobile());
        personnel.setEmail(createRequestDto.getEmail());
        return personnel;
    }
}
