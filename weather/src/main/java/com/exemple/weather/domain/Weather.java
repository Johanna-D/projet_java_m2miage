package com.exemple.weather.domain;
import io.swagger.annotations.ApiModelProperty;
public class Weather {
    @ApiModelProperty(notes = "Ville",name="ville",required=true,value="ville")
    private String ville;
    @ApiModelProperty(notes = "ZipCode",name="zipCode",required=true,value="zipCode")
    private String zipCode;
    @ApiModelProperty(notes = "Weather",name="weather",required=true,value="weather")
    private String weather;

    public Weather(String ville,String zipCode, String weather) {
        this.ville = ville;
        this.zipCode = zipCode;
        this.weather = weather;
    }

    public String getWeather() { return weather; }

    public void setWeather(String weather) { this.weather = weather; }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
