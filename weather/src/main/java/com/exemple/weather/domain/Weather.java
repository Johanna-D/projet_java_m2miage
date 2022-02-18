package com.exemple.weather.domain;

public class Weather {
    private String ville;
    private String zipCode;
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
