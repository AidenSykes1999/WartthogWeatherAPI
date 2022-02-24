package com.sparta.weatherapi;

import com.sparta.weatherapi.weatherjson.Weather;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties props = new Properties();

        try {
            props.load(new FileReader("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConnectionManager connectionManager = new ConnectionManager();
        Injector injector = new Injector();

        String stringWeather = connectionManager.getResponseByLatLon(35,139,props);
        Weather testWeather = injector.injectResponseToWeather(stringWeather);
        System.out.println(testWeather.toString());

        String stringWeatherCity = connectionManager.getResponseByCity("Zaragoza",props);
        Weather testWeather2 = injector.injectResponseToWeather(stringWeatherCity);
        System.out.println(testWeather2.toString());

        String stringWeatherZipCountry = connectionManager.getResponseByZipCountryCode("28018","es",props);
        Weather testWeather3 = injector.injectResponseToWeather(stringWeatherZipCountry);
        System.out.println(testWeather3);



    }



}
