package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave")
@NamedQueries({@NamedQuery(name = "selectAll", query = "SELECT l FROM Leave l"),
})
public class Leave  extends AbstractLeave{

    public Leave() {
    }
}
