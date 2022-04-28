package eu.dreamix.jpaRelations.model;

import javax.persistence.*;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String phone;

    @Column
    private String email;

    public Details() {
    }

    public Details(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
}
