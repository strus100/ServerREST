package matuszewski.pracownia.controller.rest;

import matuszewski.pracownia.model.Audiobooks;
import matuszewski.pracownia.model.Books;
import matuszewski.pracownia.repository.AudiobookRepository;
import matuszewski.pracownia.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audiobooks")
public class AudiobookControllerRest {

    private AudiobookRepository repository;

    @Autowired
    public AudiobookControllerRest(AudiobookRepository repository) {
        this.repository = repository;
    }

    //Wypisz wszystkie Dodaj statystkę z mw.
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Audiobooks> getAll()
    {
        return repository.findAll();
    }

    //Wypisz jedno
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Audiobooks> get(@PathVariable Long id) {
        ResponseEntity<Audiobooks> result = repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        return result;
    }

    //Zapisz jedno
    @PostMapping
    public void save(
            @RequestParam String author,
            @RequestParam String title
    ){
        Long ID = -1L;
        do {
            ID++;
        }while(repository.existsById(ID));
        repository.save(new Audiobooks(ID,author,title));
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
            @RequestParam String author,
            @RequestParam String title) {
        if(repository.existsById(id)){
            repository.findById(id).get().setAuthor(author);
            repository.findById(id).get().setTitle(title);
            repository.flush();
        }else{
            Audiobooks audiobook = new Audiobooks(id,author,title);
            repository.save(audiobook);
        }
    }
    }