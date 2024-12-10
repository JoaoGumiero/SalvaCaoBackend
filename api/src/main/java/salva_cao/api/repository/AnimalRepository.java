package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import salva_cao.api.model.Animal;

@Repository
public interface AnimalRepository<Animal, Long> extends CrudRepository<Animal, Long> {

}
