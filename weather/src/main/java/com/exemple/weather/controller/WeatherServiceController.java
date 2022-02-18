package com.exemple.weather.controller;

import com.exemple.weather.domain.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "WeatherServiceController", description = "REST Apis related to Weather Entity")
@RestController
public class WeatherServiceController {

	private Map<String, List<Weather>> weatherData = fillWeather();


	static HashMap<String, List<Weather>> fillWeather() {
		return new HashMap<String, List<Weather>>() {
			private static final long serialVersionUID = -3970206781360313502L;

			{
				put("France", new ArrayList<Weather>() {
					{
						add(new Weather("Marseille", "13000", "soleil"));
						add(new Weather("Nice", "06000", "nuages"));
						add(new Weather("Paris", "75000", "pluie"));
					}
				});
				put("Italie", new ArrayList<Weather>() {{
					add(new Weather("Venise", "30100", "pluie"));
					add(new Weather("Rome", "00100", "nuages"));
					add(new Weather("Turin", "10121", "soleil"));
				}});
			}
		};
	}

	@ApiOperation(value = "Get list of weather by pays ", response = Weather.class, tags = "getWeatherByPays")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/weatherPays/{pays}", method = RequestMethod.GET)
	public List<Weather> getWeatherByPays(@PathVariable String pays) {
		return weatherData.get(pays);
	}

	@ApiOperation(value = "Get weather by ville ", response = Weather.class, tags = "getWeatherByVille")
	@RequestMapping(value = "/weatherVille/{ville}", method = RequestMethod.GET)
	public String getWeatherByVille(@PathVariable String ville) {
		for (String pays : weatherData.keySet()) {
			for (Weather weather : weatherData.get(pays)) {
				if (weather.getVille().equals(ville)) {
					return "Ville :  " + ville + " , Météo : " + weather.getWeather();
				}
			}
		}
		return "erreur";
	}
	@ApiOperation(value = "Get weather by zipCode ", response = Weather.class, tags = "getWeatherByZipCode")
	@RequestMapping(value = "/weatherZipCode/{zipCode}", method = RequestMethod.GET)
	public String getWeatherByZipCode(@PathVariable String zipCode) {
		for (String pays : weatherData.keySet()) {
			for (Weather weather : weatherData.get(pays)) {
				if (weather.getZipCode().equals(zipCode)) {
					return "ZipCode :  " + zipCode + ", Météo : " + weather.getWeather();
				}
			}
		}
		return "erreur";

	}
}




