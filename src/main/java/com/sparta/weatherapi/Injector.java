package com.sparta.weatherapi;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapi.weatherjson.Weather;
import com.sparta.weatherapi.weatherjson.WeatherItem;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.List;

public class Injector {

     public Weather injectResponseToWeather(String response) {

         ObjectMapper objMap = new ObjectMapper();
         Weather weather = null;

         try{

             weather = objMap.readValue(response, Weather.class);
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

}
