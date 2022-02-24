package com.spartaglobal.warthog.JUnit;

import com.sparta.weatherapi.Injector;
import com.sparta.weatherapi.weatherjson.Weather;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mocking {

    public static Weather weth;

    @BeforeAll
    public static void mockSetUp()
    {
        weth = mockSetUp.createWeather("responseExample.txt");
    }

    @Test
    public void testCorrectCountry()
    {
        Assertions.assertTrue(weth.getSys().getCountry().equals("IT"));
    }
}
