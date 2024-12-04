package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import salva_cao.api.model.Animal;


public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
