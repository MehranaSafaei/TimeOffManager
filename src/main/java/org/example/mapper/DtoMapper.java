package org.example.mapper;

import org.example.controller.request.CreateRequestDto;
import org.example.entity.Leave;
import org.example.entity.Personnel;
import org.example.entity.dto.LeaveDTO;
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
        personnel.setFirstName(createRequestDto.getFirstName());
        personnel.setLastName(createRequestDto.getLastName());
        personnel.setPersonnelCode(createRequestDto.getPersonnelCode());
        personnel.setMobile(createRequestDto.getMobile());
        personnel.setEmail(createRequestDto.getEmail());
        return personnel;
    }

    public static LeaveDTO leaveDTO(Leave leave) {
        if (leave == null) {
            return null;
        }
        LeaveDTO leaveDTO = new LeaveDTO();
        leaveDTO.setId(leave.getId());
        leaveDTO.setStartDate(leave.getStartDate());
        leaveDTO.setEndDate(leave.getEndDate());
        return leaveDTO;
    }

    public static Leave leave(LeaveDTO leaveDTO) {
        if (leaveDTO == null) {
            return null;
        }
        Leave leave = new Leave();
        leave.setId(leaveDTO.getId());
        leave.setStartDate(leaveDTO.getStartDate());
        leave.setEndDate(leaveDTO.getEndDate());
        return leave;
    }
}
