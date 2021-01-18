package pl.pozadr.hellomockito.animal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pozadr.hellomockito.service.AnimalFetcher;

import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AnimalFetcherTest {

    @Spy
    private AnimalFetcher animalFetcher;

    @BeforeEach
    public void getDataFromRemoteApi() {
        given(animalFetcher.getDataFromRemoteApi()).willReturn(prepareMockData());
    }

    @Test
    public void sortData() {
        List<String> sortedAnimals = animalFetcher.getSortedData();
        List<String> patternSortedAnimals = List.of("Cat", "Dog", "Rino");

        Assertions.assertIterableEquals(patternSortedAnimals, sortedAnimals);
    }

    private List<String> prepareMockData() {
        return List.of("Rino", "Dog", "Cat");
    }

}