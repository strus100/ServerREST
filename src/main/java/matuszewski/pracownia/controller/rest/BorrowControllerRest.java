package matuszewski.pracownia.controller.rest;

import matuszewski.pracownia.model.Borrows;
import matuszewski.pracownia.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowControllerRest {

    private BorrowRepository repository;

    @Autowired
    public BorrowControllerRest(BorrowRepository repository) {
        this.repository = repository;
    }

    //Wypisz wszystkie Dodaj statystkę z mw.
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Borrows> getAll()
    {
        return repository.findAll();
    }

    //Wypisz jedno
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Borrows> get(@PathVariable Long id) {
        ResponseEntity<Borrows> result = repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        return result;
    }

    //Zapisz jedno
    @PostMapping
    public void save(
            @RequestParam boolean isBorrow
    ){
        Long ID = -1L;
        do {
            ID++;
        }while(repository.existsById(ID));
        repository.save(new Borrows(ID,isBorrow));
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
            @RequestParam boolean isBorrow){
        if(repository.existsById(id)){
            repository.findById(id).get().setIsborrow(isBorrow);

            repository.flush();
        }else{
            Borrows borrow = new Borrows(id,isBorrow);
            repository.save(borrow);
        }
    }
    }