package eu.dreamix.library.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authors", uniqueConstraints = { @UniqueConstraint(columnNames = { "firstName", "lastName" }) })
public class Author extends Person {
}
