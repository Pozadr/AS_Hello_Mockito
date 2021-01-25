package pl.pozadr.hellomockito.workshop;

import pl.pozadr.hellomockito.other.OtherWorkshopCarDetailsDTO;
import pl.pozadr.hellomockito.other.OtherWorkshopCarDetailsService;

import java.util.List;
import java.util.stream.Collectors;


public class CarDetailsConverter {

    private final OtherWorkshopCarDetailsService otherWorkshopCarDetailsService;

    public CarDetailsConverter(OtherWorkshopCarDetailsService otherWorkshopCarDetailsService) {
        this.otherWorkshopCarDetailsService = otherWorkshopCarDetailsService;
    }

    public List<CarDetails> convertAll() {
        List<OtherWorkshopCarDetailsDTO> toConvert = otherWorkshopCarDetailsService.findCarDetailsToAnalyze();
        return toConvert.stream() //
                .map(this::convert) //
                .collect(Collectors.toList());
    }

    CarDetails convert(OtherWorkshopCarDetailsDTO dto) {
        CarDetails details = new CarDetails();
        details.setId(String.valueOf(dto.getId()));
        details.setCarMillage(dto.getCarMillage());
        details.setFuelUsage(dto.getFuelUsage());
        details.setTreadThickness(dto.getTreadThickness());
        return details;
    }
}
