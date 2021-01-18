package pl.pozadr.hellomockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pozadr.hellomockito.model.Animal;
import pl.pozadr.hellomockito.repository.AnimalRepo;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepo animalRepo;

    @Autowired
    public AnimalServiceImpl(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }


    @Override
    public List<Animal> findAllAnimals() {
        return animalRepo.findAll();
    }

    @Override
    public Animal saveAnimal(Animal newAnimal) {
        return animalRepo.save(newAnimal);
    }
}
