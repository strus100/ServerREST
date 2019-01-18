package matuszewski.pracownia.controller.rest;

import matuszewski.pracownia.model.Books;
import matuszewski.pracownia.model.Orders;
import matuszewski.pracownia.repository.BookRepository;
import matuszewski.pracownia.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerRest {

    private OrderRepository repository;

    @Autowired
    public OrderControllerRest(OrderRepository repository) {
        this.repository = repository;
    }

    //Wypisz wszystkie Dodaj statystkę z mw.
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getAll()
    {
        return repository.findAll();
    }

    //Wypisz jedno
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> get(@PathVariable Long id) {
        ResponseEntity<Orders> result = repository.findById(id)
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
        repository.save(new Orders(ID,author,title));
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
            Orders Order = new Orders(id,author,title);
            repository.save(Order);
        }
    }
    }