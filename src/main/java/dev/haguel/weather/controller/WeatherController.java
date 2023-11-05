package dev.haguel.weather.controller;

import dev.haguel.weather.dto.GetCityTemperatureDTO;
import dev.haguel.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city")
    public Double getCityWeather(@RequestBody GetCityTemperatureDTO getCityTemperatureDTO) {
        return weatherService.getCityTemperature(getCityTemperatureDTO);
    }
}
