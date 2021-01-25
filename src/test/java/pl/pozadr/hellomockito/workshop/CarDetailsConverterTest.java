package pl.pozadr.hellomockito.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.pozadr.hellomockito.other.OtherWorkshopCarDetailsDTO;
import pl.pozadr.hellomockito.other.OtherWorkshopCarDetailsService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

class CarDetailsConverterTest {

    private CarDetailsConverter toTest;

    @Test
    void convertAll_simpleCaseConvertSuccess() {
        // given
        OtherWorkshopCarDetailsService service = mockOtherWorkshopCarDetailsService();
        toTest = new CarDetailsConverter(service);
        // when
        List<CarDetails> result = toTest.convertAll();
        // then
        Assertions.assertEquals(result.size(), 2);
    }

    private OtherWorkshopCarDetailsService mockOtherWorkshopCarDetailsService() {
        OtherWorkshopCarDetailsService mock = Mockito.mock(OtherWorkshopCarDetailsService.class);
        List<OtherWorkshopCarDetailsDTO> content = dbContent();
        when(mock.findCarDetailsToAnalyze()).thenReturn(content);
        return mock;
    }

    private List<OtherWorkshopCarDetailsDTO> dbContent() {
        return Arrays.asList(mockOtherWorkshopCarDetailsDTO(1, 3, 5, 10000),
                mockOtherWorkshopCarDetailsDTO(2, 4, 8, 15000));
    }


    @Test
    void convert_simpleCaseConvertSuccess() {
        // given
        toTest = new CarDetailsConverter(null);
        OtherWorkshopCarDetailsDTO objectToTest =
                mockOtherWorkshopCarDetailsDTO(1, 4, 8, 10000);
        // when
        CarDetails result = toTest.convert(objectToTest);
        // then
        Assertions.assertEquals(result.getId(), "1");
        Assertions.assertEquals(result.getCarMillage(), 10000);
        Assertions.assertEquals(result.getTreadThickness(), 4);
        Assertions.assertEquals(result.getFuelUsage(), 8);
    }

    private OtherWorkshopCarDetailsDTO mockOtherWorkshopCarDetailsDTO(Integer id, Integer treadThickness, Integer fuelUsage,
                                                                      Integer carMillage) {
        OtherWorkshopCarDetailsDTO mock = Mockito.mock(OtherWorkshopCarDetailsDTO.class);
        when(mock.getId()).thenReturn(id);
        when(mock.getCarMillage()).thenReturn(carMillage);
        when(mock.getTreadThickness()).thenReturn(treadThickness);
        when(mock.getFuelUsage()).thenReturn(fuelUsage);
        return mock;
    }
}