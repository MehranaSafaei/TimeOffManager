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


    private Long id;
    private String username;
    private Long personnelCode;
    private String mobile;
    private String email;
    private Set<Leave> leaves;


    public AbstractPersonnel() {
    }

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 50)
    @Column(name = "Username", unique = true)
    public  String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Size(max = 20)
    @Column(name = "PersonnelCode", unique = true, nullable = false)
    public Long getPersonnelCode() {
        return personnelCode;
    }
    public void setPersonnelCode(Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    @Size(max = 15)
    @Column(name = "Mobile", unique = true, nullable = false)
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Size(max = 50)
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id")
    public Set<Leave> getLeave() {
        return leaves;
    }
    public void setLeave(Set<Leave> leaves) {
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
//                ", role=" + role +
                ", email='" + email + '\'' +
//                ", leaves=" + leaves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersonnel that = (AbstractPersonnel) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) &&  Objects.equals(personnelCode, that.personnelCode) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(leaves, that.leaves) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, personnelCode, mobile, email, leaves);
    }
}
