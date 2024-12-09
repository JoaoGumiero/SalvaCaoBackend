package salva_cao.api.controller;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import salva_cao.api.model.Adoption;

@RestController
@RequestMapping("/salva-cao/adocao")
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @PostMapping
    public ResponseEntity<Adoption> createAdoption(@RequestBody Adoption adoption) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adoptionService.createAdoption(adoption));
    };

    @GetMapping("/{id}")
    public ResponseEntity<Adoption> getAdoptionById(@PathVariable long id) {
        return ResponseEntity.ok(adoptionService.getAdoptionById(id));
    };

    @GetMapping
    public ResponseEntity<Adoption> getAllAdoption() {
        return ResponseEntity.ok(adoptionService.getAllAdoptions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adoption> updateAdoption(@PathVariable Long id, @RequestBody Adoption adoption) {
        return ResponseEntity.ok(adoptionService.updateVolunteer(id, adoption));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Adoption> deleteAdoptionById(@PathVariable long id) {
       adoptionService.deleteAdoptionById(id);
       return ResponseEntity.noContent().build();
    };

}
