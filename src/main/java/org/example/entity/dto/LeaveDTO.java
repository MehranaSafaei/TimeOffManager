package org.example.entity.dto;

import org.example.entity.Personnel;
import org.example.entity.enums.LeaveType;

import java.time.LocalDate;

public class LeaveDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Personnel personnel;
    private LeaveType leaveType;

    public LeaveDTO(Long id, LocalDate startDate, LocalDate endDate, Personnel personnel, LeaveType leaveType) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.personnel = personnel;
        this.leaveType = leaveType;
    }

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

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
