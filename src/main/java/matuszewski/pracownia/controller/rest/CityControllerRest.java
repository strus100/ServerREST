package matuszewski.pracownia.controller.rest;

import matuszewski.pracownia.model.City;
import matuszewski.pracownia.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityControllerRest {

    private CityRepository cityRepo;

    @Autowired
    public CityControllerRest(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

    //Wypisz wszystkie Dodaj statystkę z mw.
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(@RequestParam(defaultValue="name") String orderBy) {


        return cityRepo.findAll();
    }

    //Wypisz jedno
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCity(@PathVariable Long id) {
        ResponseEntity<City> result = cityRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        return result;
    }

    //Zapisz jedno
    @PostMapping
    public void saveCity(
            @RequestParam String name,
            @RequestParam int population
    ){
        cityRepo.save(new City(name,population));
    }

    //Usuń jedno
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeCity(@PathVariable Long id) {
        cityRepo.delete(cityRepo.findById(id).get());
    }

    //Update jedno
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCity(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam int population) {
        if(cityRepo.existsById(id)){
            cityRepo.findById(id).get().setName(name);
            cityRepo.findById(id).get().setPopulation(population);
            cityRepo.flush();
        }else{
            City city = new City(name,population);

            cityRepo.save(city);
            city.setId(id);
            cityRepo.flush();
        }
    }
    }