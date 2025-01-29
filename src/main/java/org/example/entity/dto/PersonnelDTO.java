package org.example.entity.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class PersonnelDTO {

    private Long id;
    private String username;
    private String password;
    private Long personnelCode;
    private String mobile;
    private String email;
    private String role;


    private Set<LeaveDTO> leaveId;

    public PersonnelDTO(Long id, @Size(max = 50) String username, String mobile, String email) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.email = email;
//        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "username must be 3-20 character long")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Pattern(regexp = "^[a-zA-Z0-9._\\-~\\?!@#\\$%\\^&\\*\\(\\)]{8,20}$", message = "password must be 8-20 character")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Pattern(regexp = "[0-9]{5,10}$")
    public Long getPersonnelCode() {
        return personnelCode;
    }
    public void setPersonnelCode(Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    @Pattern(regexp = "[0-9]{5,10}$")
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Pattern(regexp = "[\\w.%+-]+@[\\w.-]+[a-zA-Z]{3,6}$")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
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