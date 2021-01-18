package pl.pozadr.hellomockito.animal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.pozadr.hellomockito.controller.AnimalController;
import pl.pozadr.hellomockito.model.Animal;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AnimalControllerTest {

    @Test
    void should_get_animal_list() {
        // given
        AnimalController animalController = mock(AnimalController.class);
        given(animalController.getAnimals()).willReturn(prepareMockData());
        // when
        Integer getAnimalsListLength = animalController.getAnimals().size();
        //than
        Assertions.assertEquals(2, getAnimalsListLength);
    }

    @Test
    void should_add_animal() {
        // given
        AnimalController animalController = mock(AnimalController.class);
        given(animalController.addAnimal(Mockito.any(Animal.class))).willReturn(new Animal("Maxik"));
        // when
        Animal newAnimal = animalController.addAnimal(new Animal());
        //than
        Assertions.assertEquals("Maxik", newAnimal.getName());
    }

    private List<Animal> prepareMockData() {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Max"));
        animalList.add(new Animal("Eli"));
        return animalList;
    }
}