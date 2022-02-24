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

        String stringWeather = connectionManager.latLonApiCall(props, 35, 139);
        Weather testWeather = injector.injectResponseToWeather(stringWeather);
        System.out.println(testWeather.toString());

        String stringWeatherCity = connectionManager.cityApiCall(props, "Zargosa");
        Weather testWeather2 = injector.injectResponseToWeather(stringWeatherCity);
        System.out.println(testWeather2.toString());

    }



}
