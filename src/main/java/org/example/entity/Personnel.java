package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
//@SecondaryTables({@SecondaryTable(name = "").@SecondaryTable(name = "")})
@NamedQueries({@NamedQuery(name = "selectAll", query = "SELECT Personnel FROM Personnel"),
@NamedQuery(name = "findById", query = "SELECT Personnel FROM Personnel WHERE Personnel.id= :id")})
public class Personnel extends AbstractPersonnel{
}
