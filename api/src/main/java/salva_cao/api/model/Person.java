package salva_cao.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String whatsappNumber;

    private int adoptionCount;

    private boolean isVolunteer;

    @OneToMany(mappedBy = "adopter")
    private List<Adoption> adoptions;


}
