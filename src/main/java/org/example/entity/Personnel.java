package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnels")
//@NamedQuery(query = "select p from Personnel p where p.name = :name ")
public class Personnel extends AbstractPersonnel{
}
