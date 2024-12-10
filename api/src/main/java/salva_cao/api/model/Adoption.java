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

    public Adoption() {}

    public Adoption(String name, Animal adopted, Person adopter, LocalDate adoptionDate) {
        this.name = name;
        this.adopted = adopted;
        this.adopter = adopter;
        this.adoptionDate = adoptionDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAdopted() {
        return adopted;
    }

    public void setAdopted(Animal adopted) {
        this.adopted = adopted;
    }

    public Person getAdopter() {
        return adopter;
    }

    public void setAdopter(Person adopter) {
        this.adopter = adopter;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}
