package com.spartaglobal.warthog.JUnit;

import com.sparta.weatherapi.Injector;
import com.sparta.weatherapi.weatherjson.Weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mockSetUp {

    public static String buildString(String file)
    {
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
        Weather wether = new Weather();
        Injector inj = new Injector();
        String input = buildString(file);
        wether = inj.injectResponseToWeather(input);

        return wether;
    }
}
