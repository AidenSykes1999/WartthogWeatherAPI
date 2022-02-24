package com.spartaglobal.warthog.JUnit;

import com.sparta.weatherapi.dtoweather.SystemInformation;
import com.sparta.weatherapi.dtoweather.Weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        SystemInformation sys  = weth.getSystemInformation();
        SystemInformation sys2 = Mockito.spy(sys);
        Mockito.when(sys2.getCountry()).thenReturn("FR");

        Assertions.assertTrue(sys2.getCountry().equals("FR"));
    }
}
