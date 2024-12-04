package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import salva_cao.api.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
