package com.example.showweather.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class ShowWeather {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMethodVille")
    @GetMapping ("/getWeatherDetailsByVille/{ville}")
    public String getWeatherVille(@PathVariable String ville) {
        String response = restTemplate
                .exchange("http://localhost:8098/weatherVille/{ville}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, ville).getBody();
        return response;
    }
    public String fallbackMethodVille(String Ville){
        return "Fallback response:Error";
    }

    @HystrixCommand(fallbackMethod = "fallbackMethodZipCode")
    @GetMapping ("/getWeatherDetailsByZipCode/{zipCode}")
    public String getWeatherZipCode(@PathVariable String zipCode) {
        String response = restTemplate
                .exchange("http://localhost:8098/weatherZipCode/{zipCode}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, zipCode).getBody();
        return response;
    }
    public String fallbackMethodZipCode(String ZipCode){
        return "Fallback response:Error";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}