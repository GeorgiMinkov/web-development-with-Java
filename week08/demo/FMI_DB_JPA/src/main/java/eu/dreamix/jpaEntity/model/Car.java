package eu.dreamix.jpaEntity.model;

import eu.dreamix.jpaEntity.model.BodyType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(indexes = { @Index(columnList = "brand")})
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 126)
    private String brand;

    @Column(unique = true)
    private String model;

    @Column
    private Double engineSize;

    @Column
    @Enumerated(EnumType.STRING)
    private BodyType body;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;
}
