package pl.pozadr.hellomockito.workshop;

import java.util.List;

public class OtherWorkshopCarService {

    private final CarService carService;

    private final CarDetailsConverter converter;

    public OtherWorkshopCarService(CarService carService, CarDetailsConverter converter) {

        this.carService = carService;
        this.converter = converter;
    }

    public List<CarDiagnosticResult> analyzeOtherWorkshopCars() {

        List<CarDetails> toAnalyze = converter.convertAll();
        return carService.analyzeCars(toAnalyze);
    }
}