package org.example.mapper;

import org.example.entity.Leave;
import org.example.entity.Personnel;
import org.example.entity.dto.LeaveDTO;
import org.example.entity.dto.PersonnelDTO;
import org.example.enums.LeaveType;

import java.time.LocalDate;

public class DtoMapper {

    // Mapping Personnel Entity to PersonnelDTO
    public static PersonnelDTO entityToDTO(Personnel personnel) {
        return new PersonnelDTO(
                personnel.getId(),
                personnel.getUsername(),
                personnel.getEmail(),
                personnel.getMobile(),
                personnel.getRole().toString()
        );
    }

    // Mapping PersonnelDTO to Personnel Entity
    public static Personnel dtoToEntity(PersonnelDTO personnelDTO) {
        Personnel personnel = new Personnel();
        personnel.setId(personnelDTO.getId());
        personnel.setUsername(personnelDTO.getUsername());
        personnel.setRole(org.example.enums.Role.valueOf(personnelDTO.getRole()));
        return personnel;
    }

    // Mapping Leave Entity to LeaveDTO
    public static LeaveDTO entityToDTO(Leave leave) {
        LeaveDTO dto = new LeaveDTO();
        dto.setId(leave.getId());
        dto.setDate(LocalDate.parse(leave.getStartDate() + " - " + leave.getEndDate()));
        dto.setLeaveType(LeaveType.valueOf(leave.getLeaveType().toString()));
        return dto;
    }

    // Mapping LeaveDTO to Leave Entity
    public static Leave dtoToEntity(LeaveDTO dto) {
        Leave leave = new Leave();
        leave.setId(dto.getId());
        leave.setStartDate(dto.getDate());
        leave.setEndDate(dto.getDate());
        leave.setLeaveType(LeaveType.valueOf(dto.getLeaveType()));
        return leave;
    }
}
