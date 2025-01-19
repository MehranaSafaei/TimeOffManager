package org.example.entity.dto;

import jakarta.validation.constraints.Pattern;

import java.util.Set;

public class PersonnelDTO {

    private Long id;
    @Pattern(regexp = "gg")
    private String username;
    private String password;
    private String personnelCode;
    private String email;
    private Set<LeaveDTO> leaves;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
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