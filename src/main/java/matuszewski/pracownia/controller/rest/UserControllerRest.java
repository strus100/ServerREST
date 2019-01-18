package matuszewski.pracownia.controller.rest;

import matuszewski.pracownia.model.Users;
import matuszewski.pracownia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllerRest {

    private UserRepository repository;

    @Autowired
    public UserControllerRest(UserRepository repository) {
        this.repository = repository;
    }

    //Wypisz wszystkie Dodaj statystkę z mw.
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAll()
    {
        return repository.findAll();
    }

    //Wypisz jedno
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> get(@PathVariable Long id) {
        ResponseEntity<Users> result = repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        return result;
    }

    //Zapisz jedno
    @PostMapping
    public void save(
            @RequestParam String firstname,
            @RequestParam String lastname
    ){
        Long ID = -1L;
        do {
            ID++;
        }while(repository.existsById(ID));
        repository.save(new Users(ID,firstname,lastname));
    }

    //Usuń jedno
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void remove(@PathVariable Long id) {
        repository.delete(repository.findById(id).get());
    }

    //Update jedno
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(
            @PathVariable Long id,
            @RequestParam String firstname,
            @RequestParam String lastname) {
        if(repository.existsById(id)){
            repository.findById(id).get().setFirstname(firstname);
            repository.findById(id).get().setLastname(lastname);
            repository.flush();
        }else{
            Users user = new Users(id,firstname,lastname);
            repository.save(user);
        }
    }
    }