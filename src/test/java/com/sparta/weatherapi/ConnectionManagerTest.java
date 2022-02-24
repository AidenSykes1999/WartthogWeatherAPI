package com.sparta.weatherapi;

import com.sparta.weatherapi.dtoweather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

}
