package salva_cao.api.service;

import org.springframework.stereotype.Service;
import salva_cao.api.model.Animal;
import salva_cao.api.model.enums.AnimalType;
import salva_cao.api.model.enums.HealthStatus;
import salva_cao.api.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // Validate Animal Data
    private void validateAnimal(Animal animal) {
        if (animal.getName() == null || animal.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (animal.getType() == null) {
            throw new IllegalArgumentException("Animal type cannot be null");
        }
        if (animal.getAge() == null || animal.getAge().isBlank()) {
            throw new IllegalArgumentException("Age cannot be null or empty");
        }
        if (animal.getRescueDate() == null || animal.getRescueDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Rescue date cannot be null or in the future");
        }
        if (animal.getHealthStatus() == null) {
            throw new IllegalArgumentException("Health status cannot be null");
        }
        if (animal.getImageUrl() == null || animal.getImageUrl().isBlank()) {
            throw new IllegalArgumentException("Image URL cannot be null or empty");
        }
    }

    // Create a new animal
    public Animal createAnimal(Animal animal) {
        validateAnimal(animal);
        animal.setAdopted(false); // New animals are not adopted by default
        animal.setDateCreated(new Date());
        animal.setDateUpdated(new Date());
        return animalRepository.save(animal);
    }

    // Retrieve an animal by ID
    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    // Retrieve all animals
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Retrieve available animals for adoption
    public List<Animal> getAvailableAnimals() {
        return animalRepository.findByIsAdopted(false);
    }

    // Update an existing animal
    public Animal updateAnimal(Long id, Animal animal) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal with id: " + id + " does not exist");
        }
        validateAnimal(animal);
        animal.setId(id); // We set the ID here in order for the JPA to aknowledge that we are updating, not creating another line within the DB
        animal.setDateUpdated(new Date());
        return animalRepository.save(animal);
    }

    // Delete an animal by ID
    public void deleteAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal with id: " + id + " does not exist");
        }
        animalRepository.deleteById(id);
    }

    // Retrieve animals by health status
    public List<Animal> getAnimalsByHealthStatus(HealthStatus healthStatus) {
        return animalRepository.findByHealthStatus(healthStatus);
    }

    // Retrieve animals by type (CAT or DOG)
    public List<Animal> getAnimalsByType(AnimalType type) {
        return animalRepository.findByType(type);
    }
}
