package salva_cao.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Adoption")
@Data
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal adopted;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person adopter;

    @Column(nullable = false)
    private LocalDate adoptionDate;

}
