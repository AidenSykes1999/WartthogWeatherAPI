package com.sparta.weatherapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapi.dtoweather.Weather;

import java.io.IOException;

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
