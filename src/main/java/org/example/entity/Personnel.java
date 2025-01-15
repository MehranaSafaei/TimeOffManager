package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnels")
public class Personnel extends AbstractPersonnel{
}
