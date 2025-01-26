package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
@NamedQueries({
        @NamedQuery(name = "selectAll", query = "SELECT p FROM Personnel p"),
        @NamedQuery(name = "findById", query = "SELECT p FROM Personnel p WHERE p.id = :id")
})
public class Personnel extends AbstractPersonnel {

    public Personnel() {
    }
}

