package dev.haguel.weather.service;

import dev.haguel.weather.dto.GetCityTemperatureDTO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    public Double getCityTemperature(GetCityTemperatureDTO getCityTemperatureDTO) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "country=" + getCityTemperatureDTO.country() +
                "&q=" + getCityTemperatureDTO.city() +
                "&units=" + getCityTemperatureDTO.units() +
                "&appid=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        JSONObject jsonObj = new JSONObject(response.getBody());

        Double temperature = jsonObj.getJSONObject("main").getDouble("temp");

        return temperature;
    }
}
