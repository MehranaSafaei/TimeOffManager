package org.example.controller.request;

public class CreateRequestDto {

    private String username;
    private String email;
    private String mobile;
    private Long personnelCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(Long personnelCode) {
        this.personnelCode = personnelCode;
    }
}
