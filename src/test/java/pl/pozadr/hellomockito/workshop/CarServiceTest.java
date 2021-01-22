package pl.pozadr.hellomockito.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class CarServiceTest {

    @Test
    public void analyzeCarByParams_millageLessThanZero_throwsIllegalArgumentException() {
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
    public void analyzeCarByParams_millageNull_throwsIllegalArgumentException() {
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

    @ParameterizedTest
    @MethodSource("dataAnalyzeCarsByParams")
    public void analyzeCarByParams_withDataFromMethod_resultFromData(Integer treadThickness, Integer fuelUsage,
                                                                     Integer carMillage, boolean requiredResult) {
        // given
        CarService carService = new CarService();
        // when
        boolean result = carService.analyzeCarByParams(treadThickness, fuelUsage, carMillage);
        // then
        Assertions.assertEquals(requiredResult, result);
    }

    private static Stream<Arguments> dataAnalyzeCarsByParams() {
        return Stream.of(
                Arguments.of(4, 5, 10000, true),
                Arguments.of(0, 14, Integer.MAX_VALUE, false),
                Arguments.of(4, 5, 30000, false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataAnalyzeCars")
    public void analyzeCars_withDataFromData_resultFromData(List<CarDetails> carDetailsList,
                                                            List<CarDiagnosticResult> expectedResults) {
        // given
        CarService carService = new CarService();
        // when
        List<CarDiagnosticResult> results = carService.analyzeCars(carDetailsList);
        // then
        Assert.assertEquals(results, expectedResults);
    }

    private static Stream<Arguments> dataAnalyzeCars() {
        return Stream.of(
                Arguments.of(createCarDetailsListFirstCase(), createExpectedResultsFirstCase()),
                Arguments.of(createCarDetailsListFalseCase(), createExpectedResultsFalseCase())
        );
    }

    private static List<CarDiagnosticResult> createExpectedResultsFirstCase() {
        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1", true));
        results.add(new CarDiagnosticResult("2", false));
        results.add(new CarDiagnosticResult("3", true));
        return results;
    }

    private static List<CarDiagnosticResult> createExpectedResultsFalseCase() {
        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1", false));
        results.add(new CarDiagnosticResult("2", false));
        results.add(new CarDiagnosticResult("3", false));
        results.add(new CarDiagnosticResult("4", false));
        results.add(new CarDiagnosticResult("5", false));
        results.add(new CarDiagnosticResult("6", false));
        return results;
    }

    private static List<CarDetails> createCarDetailsListFirstCase() {
        List<CarDetails> carDetailsList = new ArrayList<>();
        carDetailsList.add(createCarDetails("1", 3, 3, 3));
        carDetailsList.add(createCarDetails("2", 4, 5, 300000));
        carDetailsList.add(createCarDetails("3", 7, 2, 3));
        return carDetailsList;
    }

    private static List<CarDetails> createCarDetailsListFalseCase() {
        List<CarDetails> carDetailsList = new ArrayList<>();
        carDetailsList.add(createCarDetails("1", 1, 3, 3));
        carDetailsList.add(createCarDetails("2", 2, 5, 300000));
        carDetailsList.add(createCarDetails("3", 1, 2, 3));
        carDetailsList.add(createCarDetails("4", 7, 15, 3));
        carDetailsList.add(createCarDetails("5", 7, 2, 500000));
        carDetailsList.add(createCarDetails("6", 0, 0, 0));
        return carDetailsList;
    }

    private static CarDetails createCarDetails(String id, Integer treadThickness, Integer fuelUsage, Integer carMillage) {
        CarDetails carDetails = new CarDetails();
        carDetails.setId(id);
        carDetails.setTreadThickness(treadThickness);
        carDetails.setFuelUsage(fuelUsage);
        carDetails.setCarMillage(carMillage);
        return carDetails;
    }


}