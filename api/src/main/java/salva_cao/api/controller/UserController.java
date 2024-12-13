package salva_cao.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salva_cao.api.model.User;
import salva_cao.api.service.UserService;

@RestController
@RequestMapping("/salva-cao/pessoas")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createPerson(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createPerson(user));
    };

    @GetMapping("/{id}")
    public ResponseEntity<User> getPersonById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getPersonById(id));
    };

    @GetMapping
    public ResponseEntity<User> getAllPerson() {
        return ResponseEntity.ok(userService.getAllPersons());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updatePerson(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updatePerson(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletePersonById(@PathVariable long id) {
        userService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    };
}
