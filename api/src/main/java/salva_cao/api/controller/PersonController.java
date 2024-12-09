package salva_cao.api.controller;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salva-cao/pessoas")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(person));
    };

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    };

    @GetMapping
    public ResponseEntity<Person> getAllPerson() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable long id) {
        personService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    };
}
