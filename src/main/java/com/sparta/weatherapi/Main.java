package com.sparta.weatherapi;

import com.sparta.weatherapi.dtoweather.Weather;

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

        ConnectionManager connectionManager = new ConnectionManager(props);
        Injector injector = new Injector();

        String stringWeather = connectionManager.latLonApiCall(35, 139);
        Weather testWeather = injector.injectResponseToWeather(stringWeather);
        System.out.println(testWeather.toString());


        String stringWeatherCity = connectionManager.cityApiCall("New York");
        Weather testWeather2 = injector.injectResponseToWeather(stringWeatherCity);
        System.out.println(testWeather2.toString());


        String stringWeatherStateCode = connectionManager.cityApiCall("California", "US-CA");
        Weather stateCodeWeather = injector.injectResponseToWeather(stringWeatherStateCode);
        System.out.println(stateCodeWeather.toString());

        String stringWeatherCountryCode = connectionManager.cityApiCall("Beijing", "CN-BJ", "86");
        Weather countryCodeWeather = injector.injectResponseToWeather(stringWeatherCountryCode);
        System.out.println(countryCodeWeather.toString());

        String stringWeatherZipCode = connectionManager.zipCodeApiCall("32720");
        Weather weatherZipCode = injector.injectResponseToWeather(stringWeatherZipCode);
        System.out.println(weatherZipCode.toString());

        String stringWeatherZipCountryCode = connectionManager.zipCodeApiCall("WV15 6HJ", "GB");
        Weather weatherZipCountryCode = injector.injectResponseToWeather(stringWeatherZipCountryCode);
        System.out.println(weatherZipCountryCode.toString());


    }



}
