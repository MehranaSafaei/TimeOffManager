package org.example.mapper;

import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;

public class DtoMapper {

    public static PersonnelDTO personnelDTO(Personnel personnel) {
        if (personnel == null) {
            return null;
        }

        PersonnelDTO personnelDTO = new PersonnelDTO();
        personnelDTO.setId(personnel.getId());
        personnelDTO.setUsername(personnel.getUsername());
        personnelDTO.setPassword(personnel.getPassword());
        personnelDTO.setEmail(personnel.getEmail());
        personnelDTO.setPersonnelCode(personnel.getPersonnelCode());
        return personnelDTO;
    }

    public static Personnel personnel(PersonnelDTO personnelDTO) {
        if (personnelDTO == null) {
            return null;
        }

        Personnel personnel = new Personnel();
        personnel.setId(personnelDTO.getId());
        personnel.setUsername(personnelDTO.getUsername());
        personnel.setPassword(personnelDTO.getPassword());
        personnel.setEmail(personnelDTO.getEmail());
        personnel.setPersonnelCode(personnelDTO.getPersonnelCode());
        return personnel;
    }
}
