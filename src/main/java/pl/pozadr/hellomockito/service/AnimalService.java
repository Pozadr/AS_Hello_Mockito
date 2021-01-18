package pl.pozadr.hellomockito.service;

import pl.pozadr.hellomockito.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> findAllAnimals();
    Animal saveAnimal(Animal newAnimal);
}
