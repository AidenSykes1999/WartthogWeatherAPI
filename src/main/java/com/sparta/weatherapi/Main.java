package com.sparta.weatherapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapi.weatherjson.Weather;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Main {

    private static Properties props;

    public static void main(String[] args) {

        props = new Properties();

        try {
            props.load(new FileReader("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        props.getProperty("apikey");

        Weather testWeather = getWeather(10, 10);


    }

    private static Weather getWeather(int latitude, int longuitude){
        String url = "api.openweathermap.org/data/2.5/weather?"
                + "lat=" + latitude + "&lon=" + longuitude
                + "appid=" + props.getProperty("apikey");
        ObjectMapper objMap = new ObjectMapper();
        try{
            Weather weather = objMap.readValue(new URL(url), Weather.class);
            return weather;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
