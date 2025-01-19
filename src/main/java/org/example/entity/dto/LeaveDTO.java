package org.example.entity.dto;

import org.example.enums.LeaveType;

import java.time.LocalDate;

public class LeaveDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private PersonnelDTO personnel;
    private LeaveType leaveType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PersonnelDTO getPersonnel() {
        return personnel;
    }

    public void setPersonnel(PersonnelDTO personnel) {
        this.personnel = personnel;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
