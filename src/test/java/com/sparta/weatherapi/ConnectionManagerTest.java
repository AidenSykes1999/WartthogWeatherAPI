package com.sparta.weatherapi;

import com.sparta.weatherapi.dtoweather.Weather;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConnectionManagerTest {

    private static ConnectionManager connectionManager;
    private static Injector injector;

    @BeforeAll
    public static void setUp() {

        Properties props = new Properties();

        try {
            props.load(new FileReader("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        connectionManager = new ConnectionManager(props);
        injector = new Injector();

    }

    @ParameterizedTest
    @Timeout(10)
    @EnumSource(value = Languages.class)
    public void cityApiCallLanguageTest(Languages language) {

        String weatherString = connectionManager.cityApiCall("Beijing", "CN-BJ", "86", language);
        Weather weather = injector.injectResponseToWeather(weatherString);

        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());

    }

    @ParameterizedTest
    @Timeout(10)
    @EnumSource(value = Units.class)
    public void cityApiCallUnitsTest(Units units) {

        String weatherString = connectionManager.cityApiCall("Beijing", "CN-BJ", "86", units);
        Weather weather = injector.injectResponseToWeather(weatherString);

        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());

    }


    @Test
    @DisplayName("Given Language is not provides, give the correct response ")
    public void cityApiCallNoLanguage() {
        setUp();
        String weatherString = connectionManager.cityApiCall("Beijing", "CN-BJ", "86");
        Weather weather = injector.injectResponseToWeather(weatherString);

        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }
    @Test
    @DisplayName("Given State is not provides, and only City and state give the correct response ")
    public void cityApiCallNoState() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", "US-NY");
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }
    @Test
    @DisplayName("Given State is not provides, and only City, state give the correct response ")
    public void cityApiCallNoStateLanguage() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", "US-NY");
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }

    @Test
    @DisplayName("Given State is not provides, and only City, state and Units give the correct response ")
    public void cityApiCallNoStatewUnits() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", "US-NY", Units.IMPERIAL);
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }
    @Test
    @DisplayName("Given State is not provides, and only City, state and Language give the correct response ")
    public void cityApiCallNoStatewLanguage() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", "US-NY", Languages.FRENCH);
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }
    @Test
    @DisplayName("Given State is not provides, and only City, state, Units and Language give the correct response ")
    public void cityApiCallNoStatewUnitsLanguage() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", "US-NY", Units.IMPERIAL, Languages.FRENCH);
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }

    @Test
    @DisplayName("City only is provided give the correct response ")
    public void cityApiCallCityOnly() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York");
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }

    @Test
    @DisplayName("City only is provided with a language give the correct response ")
    public void cityApiCallCityOnlyLanguage() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", Languages.BULGARIAN);
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }

    @Test
    @DisplayName("City only is provided with a Unit give the correct response")
    public void cityApiCallCityOnlyUnits() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", Units.STANDARD);
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }

    @Test
    @DisplayName("City only is provided with a Unit and Language give the correct response")
    public void cityApiCallCityOnlyUnitsandLanguage() {
        setUp();

        String weatherString = connectionManager.cityApiCall("New York", Units.STANDARD, Languages.FRENCH);
        Weather weather = injector.injectResponseToWeather(weatherString);
        System.out.println(weather);

        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }
}
