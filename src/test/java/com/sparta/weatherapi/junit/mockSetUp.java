package com.sparta.weatherapi.junit;

import com.sparta.weatherapi.Injector;
import com.sparta.weatherapi.dtoweather.Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mockSetUp {

    public static String buildString(String file)
    {
        //takes in the JSON file and turns it into one long string the injector to use
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static Weather createWeather(String file)
    {
        //creates a custom Weather object, taking in a .txt file of a JSON class
        Weather weather;
        Injector inj = new Injector();
        String input = buildString(file);
        //turns the string into a weather object using the injector class
        weather = inj.injectResponseToWeather(input);

        return weather;
    }
}
