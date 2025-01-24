package org.example.mapper;

import org.example.entity.Leave;
import org.example.entity.Personnel;
import org.example.entity.dto.LeaveDTO;
import org.example.entity.dto.PersonnelDTO;
import org.example.enums.LeaveType;

public class DtoMapper {

    // Mapping Personnel Entity to PersonnelDTO
    public static PersonnelDTO personnelToDTO(Personnel personnel) {
        return new PersonnelDTO(
                personnel.getId(),
                personnel.getUsername(),
                personnel.getEmail(),
                personnel.getRole().toString()
        );
    }

    // Mapping PersonnelDTO to Personnel Entity
    public static Personnel personnelToEntity(PersonnelDTO personnelDTO) {
        Personnel personnel = new Personnel();
        personnel.setId(personnelDTO.getId());
        personnel.setUsername(personnelDTO.getUsername());  // Corrected from setUsename to setUsername
        personnel.setRole(org.example.enums.Role.valueOf(personnelDTO.getRole().toUpperCase()));
        return personnel;
    }

    // Mapping Leave Entity to LeaveDTO
    public static LeaveDTO leaveToDTO(Leave leave) {
        LeaveDTO dto = new LeaveDTO();
        dto.setId(leave.getId());
        dto.setStartDate(leave.getStartDate());
        dto.setEndDate(leave.getEndDate());
        dto.setLeaveType(LeaveType.valueOf(leave.getLeaveType().toString()));
        return dto;
    }

    // Mapping LeaveDTO to Leave Entity
    public static Leave leaveToEntity(LeaveDTO dto) {
        Leave leave = new Leave();
        leave.setId(dto.getId());
        leave.setStartDate(dto.getStartDate());
        leave.setEndDate(dto.getEndDate());
        leave.setLeaveType(LeaveType.valueOf(dto.getLeaveType()));
        return leave;
    }
}
