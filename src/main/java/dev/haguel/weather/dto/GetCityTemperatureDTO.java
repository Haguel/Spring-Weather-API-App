package dev.haguel.weather.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GetCityTemperatureDTO(
    @NotBlank(message = "Please, provide city name.")
    String city,

    @Size(min = 2, max = 2, message = "Please provide country code (e.g. \"US\" for United States).")
    String country,

    String units
) {
    public GetCityTemperatureDTO {
        units = units == null ? "metric" : units;
    }
}
