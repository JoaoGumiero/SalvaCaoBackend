package salva_cao.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/salva-cao/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.createAnimal(animal));
    };

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable long id) {
        return ResponseEntity.ok(animalService.getAnimalById(id));
    };

    @GetMapping
    public ResponseEntity<Animal> getAllAnimal() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        return ResponseEntity.ok(animalService.updateAnimal(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Animal> deleteAnimalById(@PathVariable long id) {
        animalService.deleteAnimalById(id);
        return ResponseEntity.noContent().build();
    };

}
