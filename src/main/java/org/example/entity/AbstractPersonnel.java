package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.example.enums.Role;

import java.util.Objects;
import java.util.Set;

@MappedSuperclass
public class AbstractPersonnel {
    //TODO: field
    //TODO:ORM Hibernate-->mapping and column and generate(Table-identity-sequence)---->lazy/eager? cascade orphanRemoval insertable and updatable scale(id)?

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 50)
    @Column(name = "Username", unique = true)
    private String username;

//    @Size(max = 50)
//    @Column(name = "Password", unique = true, updatable = true)
//    private String password;

    @Size(max = 20)
    @Column(name = "PersonnelCode", unique = true, nullable = false)
    private Long personnelCode;

    @Size(max = 15)
    @Column(name = "Mobile", unique = true, nullable = false)
    private String mobile;

    @Enumerated(EnumType.STRING)
    private org.example.enums.Role role;

    @Size(max = 50)
    @Column(name = "Email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Leave> leaves;

    public AbstractPersonnel() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public @Size(max = 50) String getUsername() {
        return username;
    }
    public void setUsername(@Size(max = 50) String username) {
        this.username = username;
    }

    public @Size(max = 20) Long getPersonnelCode() {
        return personnelCode;
    }
    public void setPersonnelCode(@Size(max = 20) Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    public @Size(max = 15) String getMobile() {
        return mobile;
    }
    public void setMobile(@Size(max = 15) String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(org.example.enums.Role role) {
        this.role = role;
    }

    public @Size(max = 50) String getEmail() {
        return email;
    }
    public void setEmail(@Size(max = 50) String email) {
        this.email = email;
    }

    public Set<Leave> getLeaves() {
        return leaves;
    }
    public void setLeaves(Set<Leave> leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return "AbstractPersonnel{" +
                "id=" + id +
                ",username='" + username + '\'' +
//                ", password='" + password + '\'' +
                ", personnelCode=" + personnelCode +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", leaves=" + leaves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersonnel that = (AbstractPersonnel) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) &&  Objects.equals(personnelCode, that.personnelCode) && Objects.equals(mobile, that.mobile) && role == that.role && Objects.equals(email, that.email) && Objects.equals(leaves, that.leaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, personnelCode, mobile, role, email, leaves);
    }
}
