package org.example.entity;

import jakarta.persistence.*;
import org.example.enums.LeaveType;

import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
@IdClass(Leave.class)
public class AbstractLeave {

    //TODO: field
    //TODO:ORM Hibernate-->mapping and column and generate(Table-identity-sequence)---->lazy/eager? cascade orphanRemoval insertable and updatable scale(id)?
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // because I use postgres
    private Long id;

    @Column(name = "StartDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDate endDate;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", foreignKey = @ForeignKey(name = "fk_personnel_leave"))
    private Personnel personnel;

    @Column(name = "LeaveType")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    public AbstractLeave() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "AbstractLeave{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", personnel=" + personnel +
                ", leaveType=" + leaveType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractLeave that = (AbstractLeave) o;
        return Objects.equals(id, that.id) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(description, that.description) && Objects.equals(personnel, that.personnel) && leaveType == that.leaveType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, description, personnel, leaveType);
    }
}
