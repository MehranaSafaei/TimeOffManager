package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

@MappedSuperclass
public class AbstractPersonnel {
    //TODO: field
    //TODO:ORM Hibernate-->mapping and column and generate(Table-identity-sequence)---->lazy/eager? cascade orphanRemoval insertable and updatable scale(id)?

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "Name", unique = true)
    private String username;

    @Size(max = 50)
    @Column(name = "Password", unique = true, nullable = false, updatable = true)
    private String password;

    @Size(max = 20)
    @Column(name = "PersonnelCode", unique = true, nullable = false)
    private String personnelCode;

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

    @Override
    public String toString() {
        return "AbstractPersonnel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personnelCode='" + personnelCode + '\'' +
                ", email='" + email + '\'' +
                ", leaves=" + leaves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersonnel that = (AbstractPersonnel) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(personnelCode, that.personnelCode) && Objects.equals(email, that.email) && Objects.equals(leaves, that.leaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, personnelCode, email, leaves);
    }

}
