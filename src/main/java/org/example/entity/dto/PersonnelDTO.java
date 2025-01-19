package org.example.entity.dto;

import jakarta.validation.constraints.Pattern;

import java.util.Set;

public class PersonnelDTO {

    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "username must be 3-20 character long")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "username must be 3-20 character long")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9._\\-~\\?!@#\\$%\\^&\\*\\(\\)]{8,20}$", message = "password must be 8-20 character")
    private String password;

    @Pattern(regexp = "[0-9]{5,10}$")
    private Long personnelCode;

    @Pattern(regexp = "[\\w.%+-]+@[\\w.-]+[a-zA-Z]{3,6}$")
    private String email;

    private Set<LeaveDTO> leaves;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<LeaveDTO> getLeaves() {
        return leaves;
    }

    public void setLeaves(Set<LeaveDTO> leaves) {
        this.leaves = leaves;
    }
}