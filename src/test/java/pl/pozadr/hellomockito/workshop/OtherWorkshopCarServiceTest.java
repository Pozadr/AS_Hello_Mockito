package pl.pozadr.hellomockito.workshop;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OtherWorkshopCarServiceTest {

    @Test
    void analyzeOtherWorkshopCars_basicCase_success() {
        // given
        List<CarDetails> carDetails = new ArrayList<>();
        CarService carService = mockCarService();
        CarDetailsConverter converter = mockCarDetailsConverter(carDetails);
        OtherWorkshopCarService service = new OtherWorkshopCarService(carService, converter);
        // when
        service.analyzeOtherWorkshopCars();
        // then
        Mockito.verify(carService).analyzeCars(carDetails);
    }

    private CarService mockCarService() {
        return Mockito.mock(CarService.class);
    }

    private CarDetailsConverter mockCarDetailsConverter(List<CarDetails> carDetails) {
        CarDetailsConverter mock = Mockito.mock(CarDetailsConverter.class);
        when(mock.convertAll()).thenReturn(carDetails);
        return mock;
    }
}