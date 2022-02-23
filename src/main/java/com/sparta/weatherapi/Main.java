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

        Weather testWeather = connectionManager.getWeather(props, 35, 139);
        System.out.println(testWeather.toString());

    }



}
