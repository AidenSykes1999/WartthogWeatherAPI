package com.spartaglobal.warthog.JUnit;

import com.sparta.weatherapi.Injector;
import com.sparta.weatherapi.weatherjson.Sys;
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
        //creates a base class to mock using a given example before the tests are ran
        weth = mockSetUp.createWeather("responseExample.txt");
    }

    @Test
    @DisplayName("Given that the provided example gives FR as the country. Check that this is correctly returned")
    public void testCorrectCountry()
    {
        Sys sys  = weth.getSys();
        Sys sys2 = Mockito.spy(sys);
        Mockito.when(sys2.getCountry()).thenReturn("FR");

        Assertions.assertTrue(sys2.getCountry().equals("FR"));
    }
}
