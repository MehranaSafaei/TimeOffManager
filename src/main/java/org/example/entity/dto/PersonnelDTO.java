package org.example.entity.dto;

import org.example.entity.Leave;

import java.util.Set;

public class PersonnelDTO {

    private Long id;
    private String username;
    private String password;
    private String personnelCode;
    private String email;
    private Set<Leave> leaves;

    public PersonnelDTO(Long id, String username, String password, String personnelCode, String email, Set<Leave> leaves) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personnelCode = personnelCode;
        this.email = email;
        this.leaves = leaves;
    }

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

    public Set<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(Set<Leave> leaves) {
        this.leaves = leaves;
    }
}
