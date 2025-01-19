package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import javax.management.relation.Role;
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
    @Column(name = "First_Name", unique = true)
    private String firstName;

    @Size(max = 50)
    @Column(name = "Last_Name", unique = true)
    private String lastName;

    @Size(max = 50)
    @Column(name = "Password", unique = true, nullable = false, updatable = true)
    private String password;

    @Size(max = 20)
    @Column(name = "PersonnelCode", unique = true, nullable = false)
    private Long personnelCode;

    @Size(max = 15)
    @Column(name = "Mobile", unique = true, nullable = false)
    private String mobile;
//    private Set<Role> roles;

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

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", personnelCode='" + personnelCode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", leaves=" + leaves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersonnel that = (AbstractPersonnel) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(password, that.password) && Objects.equals(personnelCode, that.personnelCode) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(leaves, that.leaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, personnelCode, mobile, email, leaves);
    }
}
