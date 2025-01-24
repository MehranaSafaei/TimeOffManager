package org.example.entity.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class PersonnelDTO {

    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "username must be 3-20 character long")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9._\\-~\\?!@#\\$%\\^&\\*\\(\\)]{8,20}$", message = "password must be 8-20 character")
    private String password;

    @Pattern(regexp = "[0-9]{5,10}$")
    private Long personnelCode;

    @Pattern(regexp = "[\\w.%+-]+@[\\w.-]+[a-zA-Z]{3,6}$")
    private String email;

    private String role;


    private Set<LeaveDTO> leaveId;

    public PersonnelDTO(Long id, @Size(max = 50) String usename, String role, String email) {
        this.id = id;
        this.username = usename;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "username must be 3-20 character long") String getUsername() {
        return username;
    }

    public void setUsername(@Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "username must be 3-20 character long") String username) {
        this.username = username;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9._\\-~\\?!@#\\$%\\^&\\*\\(\\)]{8,20}$", message = "password must be 8-20 character") String getPassword() {
        return password;
    }

    public void setPassword(@Pattern(regexp = "^[a-zA-Z0-9._\\-~\\?!@#\\$%\\^&\\*\\(\\)]{8,20}$", message = "password must be 8-20 character") String password) {
        this.password = password;
    }

    public @Pattern(regexp = "[0-9]{5,10}$") Long getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(@Pattern(regexp = "[0-9]{5,10}$") Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    public @Pattern(regexp = "[\\w.%+-]+@[\\w.-]+[a-zA-Z]{3,6}$") String getEmail() {
        return email;
    }

    public void setEmail(@Pattern(regexp = "[\\w.%+-]+@[\\w.-]+[a-zA-Z]{3,6}$") String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<LeaveDTO> getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Set<LeaveDTO> leaveId) {
        this.leaveId = leaveId;
    }
}