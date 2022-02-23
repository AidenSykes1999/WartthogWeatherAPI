package com.sparta.weatherapi;

import com.sparta.weatherapi.weatherjson.Weather;
import io.cucumber.java.sl.In;

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

        String stringWeather = connectionManager.newMethod(props, 35, 139);
        Weather testWeather = injector.injectResponseToWeather(stringWeather);
        System.out.println(testWeather.toString());

    }



}
