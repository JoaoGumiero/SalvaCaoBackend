package salva_cao.api.model;


import jakarta.persistence.*;
import lombok.Data;
import salva_cao.api.model.enums.AnimalType;
import salva_cao.api.model.enums.HealthStatus;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnimalType type; // CAT or DOG

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private LocalDate rescueDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HealthStatus healthStatus;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private boolean isAdopted;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date dateUpdated;

    public Animal(Long id, String name, AnimalType type, String age, LocalDate rescueDate, HealthStatus healthStatus, String imageUrl, boolean isAdopted, Date dateCreated, Date dateUpdated) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.rescueDate = rescueDate;
        this.healthStatus = healthStatus;
        this.imageUrl = imageUrl;
        this.isAdopted = isAdopted;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDate getRescueDate() {
        return rescueDate;
    }

    public void setRescueDate(LocalDate rescueDate) {
        this.rescueDate = rescueDate;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
