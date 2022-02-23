package com.sparta.weatherapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapi.weatherjson.Weather;
import com.sparta.weatherapi.weatherjson.WeatherItem;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Properties;

public class ConnectionManager {

    public Weather getWeather(Properties props, int latitude, int longuitude) {

        String url = "http://api.openweathermap.org/data/2.5/weather?"
                + "lat=" + latitude + "&lon=" + longuitude
                + "&appid=" + props.getProperty("apikey");

        ObjectMapper objMap = new ObjectMapper();
        Weather weather = null;

        try{

            weather = objMap.readValue(new URL(url), Weather.class);
            List<WeatherItem> weatherItems = weather.getWeather();

            for( WeatherItem weatherItem : weatherItems){
                System.out.println(weatherItem.toString());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }


    public HttpResponse<String> newMethod(Properties props, int latitude, int longuitude) {

        String url = "http://api.openweathermap.org/data/2.5/weather?"
                + "lat=" + latitude + "&lon=" + longuitude
                + "&appid=" + props.getProperty("apikey");
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        try{
            HttpResponse<String> response =
                    httpClient.send(request,HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

}
