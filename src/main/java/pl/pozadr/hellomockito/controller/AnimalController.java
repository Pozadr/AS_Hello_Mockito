package pl.pozadr.hellomockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    public List<Animal> getAnimals() {
        return animalService.findAllAnimals();
    }

    public Animal addAnimal(Animal newAnimal) {
        return animalService.saveAnimal(newAnimal);
    }


}
