package pl.pozadr.hellomockito.animal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.pozadr.hellomockito.model.Animal;
import pl.pozadr.hellomockito.repository.AnimalRepo;
import pl.pozadr.hellomockito.service.AnimalServiceImpl;

import java.util.List;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    @Mock
    private AnimalRepo animalRepo;

    @InjectMocks
    AnimalServiceImpl animalService;

    @BeforeEach
    public void init() {
        given(animalRepo.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void should_check_animal_list_length() {
        List<Animal> animalList = animalService.findAllAnimals();
        Assertions.assertEquals(2, animalList.size());
    }

    private List<Animal> prepareMockData() {
        return List.of(new Animal("Maxik"),
                new Animal("Eli"));
    }

}