package com.sparta.weatherapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapi.weatherjson.Weather;
import com.sparta.weatherapi.weatherjson.WeatherItem;

import java.io.IOException;
import java.util.List;

public class Injector {

     public Weather injectResponseToWeather(String response) {

         ObjectMapper objMap = new ObjectMapper();
         Weather weather = null;

         try{
             weather = objMap.readValue(response, Weather.class);
         }
         catch (IOException e) {
             e.printStackTrace();
         }

         return weather;

     }

}
