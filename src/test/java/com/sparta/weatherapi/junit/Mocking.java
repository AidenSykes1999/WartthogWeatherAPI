package com.sparta.weatherapi.junit;

import com.sparta.weatherapi.ConnectionManager;
import com.sparta.weatherapi.dtoweather.Coordinates;
import com.sparta.weatherapi.dtoweather.SystemInformation;
import com.sparta.weatherapi.dtoweather.Weather;

import com.sparta.weatherapi.dtoweather.Wind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Mocking {

    public static Weather weather;

    @BeforeAll
    public static void mockSetUp()
    {
        //creates a base class to mock using a given example before the tests are ran
        weather = mockSetUp.createWeather("responseExample.txt");
    }

    @Test
    @DisplayName("Given a mock connection, confirm that the class is working and returns the string")
    public void mockConnection()
    {
        ConnectionManager mock = Mockito.mock(ConnectionManager.class);
        Mockito.when(mock.cityApiCall("London")).thenReturn("Working");

        Assertions.assertTrue(mock.cityApiCall("London") == "Working");
    }
    @Test
    @DisplayName("Given that the provided example gives FR as the country. Check that this is correctly returned")
    public void testCorrectCountry()
    {
        SystemInformation sys2 = Mockito.spy(weather.getSystemInformation());
        Mockito.when(sys2.getCountry()).thenReturn("FR");
        Assertions.assertTrue(sys2.getCountry().equals("FR"));
    }

    @Test
    @DisplayName("Given that the provided example has long and latitude of 100,100. Check that ToString is returned correctly")
    public void testCorrectLONGLAT()
    {
        Coordinates sys2 = Mockito.spy(weather.getCoordinates());
        Mockito.when(sys2.toString()).thenReturn("Coordinates: { longitude: 100°, latitude: 100°}");
        Assertions.assertTrue(sys2.toString().equals("Coordinates: { longitude: 100°, latitude: 100°}"));
    }



    @Test
    @DisplayName("Given that the provided example has wind speed of 50. Check that getSpeed is returned correctly")
    public void testCorrectWind()
    {
        Wind sys2 = Mockito.spy(weather.getWind());
        Mockito.when(sys2.getSpeed()).thenReturn(50.0);
        Assertions.assertTrue(sys2.getSpeed() == 50.0);
    }
}
