package salva_cao.api.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import salva_cao.api.model.Adoption;
import salva_cao.api.repository.AdoptionRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdoptionService {

    private final AdoptionRepository repository;

    public AdoptionService(AdoptionRepository repository) {
        this.repository = repository;
    }

    private void validateAdoption(Adoption adoption) {
        if (adoption.getName() == null || adoption.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (adoption.getAdopted() == null) {
            throw new IllegalArgumentException("Adopted animal cannot be null");
        }
        if (adoption.getAdopter() == null) {
            throw new IllegalArgumentException("Adopter cannot be null");
        }
        if (adoption.getAdoptionDate() == null || adoption.getAdoptionDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de adoção não pode ser nula ou em data futura.");
        }
        // Checking if the adopted animal is already linked
        Optional<Adoption> existingAdoption = repository.findByAdopted(adoption.getAdopted());
        if (existingAdoption.isPresent()) {
            throw new IllegalStateException("Esse animal já foi adotado.");
        }
    }


    public Adoption createAdoption(Adoption adoption) {
        validateAdoption(adoption);
        return repository.save(adoption);
    }


    public Optional<Adoption> getAdoptionById(long id) {
        return repository.findById(id);
    }

    public List<Adoption> getAllAdoptions() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Adoption updateAdoption(Long id, Adoption adoption) {
        if (adoption.getId() == null) {
            throw new IllegalArgumentException("Id da adoção não pode ser nulo");
        }
        validateAdoption(adoption);
        return repository.save(adoption);
    }

    public void deleteAdoptionById(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("A adoção de id: " + id + " não existe");
        }
        repository.deleteById(id);
    }
}
