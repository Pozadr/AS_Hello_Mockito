package pl.pozadr.hellomockito.workshop;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestNGCarServiceTest {

    @Test(dataProvider = "data")
    public void analyzeCars_withDataFromDataProvider_resultFromDataProvider(List<CarDetails> carDetailsList,
                                                                            List<CarDiagnosticResult> expectedResults) {
        // given
        CarService carService = new CarService();
        // when
        List<CarDiagnosticResult> results = carService.analyzeCars(carDetailsList);
        // then
        Assert.assertEquals(results, expectedResults);
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                {createCarDetailsListFirstCase(), createExpectedResultsFirstCase()},
                {createCarDetailsListFalseCase(), createExpectedResultsFalseCase()}
        };
    }

    private List<CarDiagnosticResult> createExpectedResultsFirstCase() {
        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1", true));
        results.add(new CarDiagnosticResult("2", false));
        results.add(new CarDiagnosticResult("3", true));
        return results;
    }

    private List<CarDiagnosticResult> createExpectedResultsFalseCase() {
        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1", false));
        results.add(new CarDiagnosticResult("2", false));
        results.add(new CarDiagnosticResult("3", false));
        results.add(new CarDiagnosticResult("4", false));
        results.add(new CarDiagnosticResult("5", false));
        results.add(new CarDiagnosticResult("6", false));
        return results;
    }

    private List<CarDetails> createCarDetailsListFirstCase() {
        List<CarDetails> carDetailsList = new ArrayList<>();
        carDetailsList.add(createCarDetails("1", 3, 3, 3));
        carDetailsList.add(createCarDetails("2", 4, 5, 300000));
        carDetailsList.add(createCarDetails("3", 7, 2, 3));
        return carDetailsList;
    }

    private List<CarDetails> createCarDetailsListFalseCase() {
        List<CarDetails> carDetailsList = new ArrayList<>();
        carDetailsList.add(createCarDetails("1", 1, 3, 3));
        carDetailsList.add(createCarDetails("2", 2, 5, 300000));
        carDetailsList.add(createCarDetails("3", 1, 2, 3));
        carDetailsList.add(createCarDetails("4", 7, 15, 3));
        carDetailsList.add(createCarDetails("5", 7, 2, 500000));
        carDetailsList.add(createCarDetails("6", 0, 0, 0));
        return carDetailsList;
    }

    private CarDetails createCarDetails(String id, Integer treadThickness, Integer fuelUsage, Integer carMillage) {
        CarDetails carDetails = new CarDetails();
        carDetails.setId(id);
        carDetails.setTreadThickness(treadThickness);
        carDetails.setFuelUsage(fuelUsage);
        carDetails.setCarMillage(carMillage);
        return carDetails;
    }
}
