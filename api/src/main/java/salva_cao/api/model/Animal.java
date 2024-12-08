package salva_cao.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "animals")
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type; // CAT or DOG

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private LocalDate rescueDate;

    @Column(nullable = false)
    private String healthStatus;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private boolean isAdopted;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date dateUpdated;
}
