package pl.pozadr.hellomockito.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarServiceTest {

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

    @Test
    void analyzeCarByParams_allValuesOk_resultTrue() {
        // given
        Integer treadThickness = 4;
        Integer fuelUsage = 5;
        Integer carMillage = 10000;
        CarService carService = new CarService();
        // when
        boolean result = carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage);
        // then
        Assertions.assertTrue(result);
    }

    @Test
    void analyzeCarByParams_carMillageNotOk_resultFalse() {
        // given
        Integer treadThickness = 4;
        Integer fuelUsage = 5;
        Integer carMillage = 30000;
        CarService carService = new CarService();
        // when
        boolean result = carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage);
        // then
        Assertions.assertFalse(result);
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
    void analyzeCarByParams_valuesEqualsToMinOrMax_resultFalse() {
        // given
        Integer treadThickness = 0;
        Integer fuelUsage = 14;
        Integer carMillage = Integer.MAX_VALUE;
        CarService carService = new CarService();
        // when
        boolean result = carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage);
        // then
        Assertions.assertFalse(result);
    }
}