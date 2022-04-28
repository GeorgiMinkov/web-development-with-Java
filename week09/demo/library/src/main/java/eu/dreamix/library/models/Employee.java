package eu.dreamix.library.models;

import eu.dreamix.library.models.enums.Position;

import javax.persistence.*;

@Entity
@Table(name = "employees", uniqueConstraints = { @UniqueConstraint(columnNames = { "firstName", "lastName" }) })
public class Employee extends Person {

    @Enumerated(EnumType.STRING)
    @Column
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
