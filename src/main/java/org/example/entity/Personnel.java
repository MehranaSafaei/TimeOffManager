package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
//@SecondaryTables({@SecondaryTable(name = "").@SecondaryTable(name = "")})
@NamedQuery(name = "selectAll", query = "SELECT Personnel FROM Personnel")
public class Personnel extends AbstractPersonnel{
}
