package org.example.entity.dto;

import org.example.enums.LeaveType;

import java.time.LocalDate;

public class LeaveDTO {

    private Long id;
    private LocalDate Date;
    private String description;
    private String leaveType;
    private PersonnelDTO personnelId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return Date;
    }
    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public PersonnelDTO getPersonnelId() {
        return personnelId;
    }
    public void setPersonnelId(PersonnelDTO personnelId) {
        this.personnelId = personnelId;
    }

    public String getLeaveType() {
        return leaveType;
    }
    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = String.valueOf(leaveType);
    }
}
