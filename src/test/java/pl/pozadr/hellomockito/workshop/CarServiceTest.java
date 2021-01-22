package pl.pozadr.hellomockito.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarServiceTest {

    @ParameterizedTest
    @MethodSource("data")
    void analyzeCarByParams_withDataFromMethod_resultFromData(Integer treadThickness, Integer fuelUsage,
                                                              Integer carMillage, boolean requiredResult) {
        // given
        CarService carService = new CarService();
        // when
        boolean result = carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage);
        // then
        Assertions.assertEquals(requiredResult, result);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(4, 5, 10000, true),
                Arguments.of(0, 14, Integer.MAX_VALUE, false),
                Arguments.of(4, 5, 30000, false)
        );
    }

    @Test
    void analyzeCarByParams_millageLessThanZero_throwsIllegalArgumentException() {
        // given
        Integer treadThickness = 4;
        Integer fuelUsage = 5;
        Integer carMillage = -30000;
        CarService carService = new CarService();
        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage));
    }

    @Test
    void analyzeCarByParams_millageNull_throwsIllegalArgumentException() {
        // given
        Integer treadThickness = 4;
        Integer fuelUsage = 5;
        Integer carMillage = null;
        CarService carService = new CarService();
        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage));
    }
}