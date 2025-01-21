package org.example.controller.request;

import org.example.entity.dto.PersonnelDTO;

import java.time.LocalDate;

public class RequestDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private PersonnelDTO personnelId;

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

    public PersonnelDTO getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(PersonnelDTO personnelId) {
        this.personnelId = personnelId;
    }
}
