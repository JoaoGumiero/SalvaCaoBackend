package salva_cao.api.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
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

    private boolean isAdopted;
}
