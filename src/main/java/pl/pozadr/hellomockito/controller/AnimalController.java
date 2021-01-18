package pl.pozadr.hellomockito.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.pozadr.hellomockito.model.Animal;
import pl.pozadr.hellomockito.service.AnimalService;

import java.util.List;

@Controller
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        List<Animal> animalList = animalService.findAllAnimals();
        return animalList;
    }

    @PostMapping("/add-animal")
    public Animal addAnimal(@RequestBody Animal newAnimal) {
        Animal addedAnimal = animalService.saveAnimal(newAnimal);
        return addedAnimal;
    }


}
