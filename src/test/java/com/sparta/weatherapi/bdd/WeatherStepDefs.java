package com.sparta.weatherapi.bdd;

import com.sparta.weatherapi.ConnectionManager;
import com.sparta.weatherapi.Injector;
import com.sparta.weatherapi.Languages;
import com.sparta.weatherapi.Units;
import com.sparta.weatherapi.dtoweather.Weather;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WeatherStepDefs {

    Properties props;
    ConnectionManager connectionManager;
    Injector injector;
    String apiKey;
    String connectionCity;
    Weather weather;
    Units units;
    Languages languages;
    String connectionCityUnits;
    private double temperatureMetric;
    private double temperatureImperial;
    private double temperatureStandard;
    private double feelsLikeMetric;
    private double feelsLikeImperial;
    private double feelsLikeStandard;
    private int pressureMetric;
    private int pressureImperial;
    private int pressureStandard;
    private int humidityMetric;
    private int humidityImperial;
    private int humidityStandard;
    private double temperatureMinMetric;
    private double temperatureMinImperial;
    private double temperatureMinStandard;
    private double temperatureMaxMetric;
    private double temperatureMaxImperial;
    private double temperatureMaxStandard;
    private int seaLevelPressureMetric;
    private int seaLevelPressureImperial;
    private int seaLevelPressureStandard;
    private int groundLevelPressureMetric;
    private int groundLevelPressureImperial;
    private int groundLevelPressureStandard;

    @Before
    public void setUp() {
        props = new Properties();

        try {
            props.load(new FileReader("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        injector = new Injector();
        connectionManager = new ConnectionManager(props);
    }

    @After
    public void tearDown(){
        props = null;
        injector = null;
        connectionManager = null;
    }

    @Then("status code is {int}")
    public void status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,connectionManager.getStatusCode());
    }

    @When("I set query param {string} as {string}")
    public void iSetQueryParamAs(String q, String city) {
        connectionCity = connectionManager.cityApiCall(city);
        weather = injector.injectResponseToWeather(connectionCity);
    }

    @Then("message {string} should appear")
    public void messageShouldAppear(String message) {
        Assert.assertEquals(message, weather.getMessage());
    }

    @When("I set query param {string} as {string}, {string} as {string}")
    public void iSetQueryParamAsAs(String q, String city, String units, String unitsValue) {
        connectionCity = connectionManager.cityApiCall(city, "", "", Units.valueOf(unitsValue.toUpperCase()));
        weather = injector.injectResponseToWeather(connectionCity);
    }

    @Then("temperature in metric and imperial are different")
    public void temperatureInMetricAndImperialAreDifferent() {
        Assert.assertFalse(temperatureImperial == temperatureMetric);
    }

    @Then("take {string} in {string}")
    public void takeIn(String generalConditions, String units) {
        switch (units) {
            case "metric":
                switch (generalConditions) {
                    case "temperature":
                        temperatureMetric = weather.getGeneralConditions().getTemperature();
                    case "feelslike":
                        feelsLikeMetric = weather.getGeneralConditions().getFeelsLike();
                    case "pressure":
                        pressureMetric = weather.getGeneralConditions().getPressure();
                    case "humidity":
                        humidityMetric = weather.getGeneralConditions().getHumidity();
                    case "temperatureMin":
                        temperatureMinMetric = weather.getGeneralConditions().getTemperatureMin();
                    case "temperatureMax":
                        temperatureMaxMetric = weather.getGeneralConditions().getTemperatureMax();
                    case "seaLevelPressure":
                        seaLevelPressureMetric = weather.getGeneralConditions().getSeaLevelPressure();
                    case "groundLevelPressure":
                        groundLevelPressureMetric = weather.getGeneralConditions().getGroundLevelPressure();
                }
            case "imperial":
                switch (generalConditions) {
                    case "temperature":
                        temperatureImperial = weather.getGeneralConditions().getTemperature();
                    case "feelslike":
                        feelsLikeImperial = weather.getGeneralConditions().getFeelsLike();
                    case "pressure":
                        pressureImperial = weather.getGeneralConditions().getPressure();
                    case "humidity":
                        humidityImperial = weather.getGeneralConditions().getHumidity();
                    case "temperatureMin":
                        temperatureMinImperial = weather.getGeneralConditions().getTemperatureMin();
                    case "temperatureMax":
                        temperatureMaxImperial = weather.getGeneralConditions().getTemperatureMax();
                    case "seaLevelPressure":
                        seaLevelPressureImperial = weather.getGeneralConditions().getSeaLevelPressure();
                    case "groundLevelPressure":
                        groundLevelPressureImperial = weather.getGeneralConditions().getGroundLevelPressure();
                }
            default:
                switch (generalConditions) {
                    case "temperature":
                        temperatureStandard = weather.getGeneralConditions().getTemperature();
                    case "feelslike":
                        feelsLikeStandard = weather.getGeneralConditions().getFeelsLike();
                    case "pressure":
                        pressureStandard = weather.getGeneralConditions().getPressure();
                    case "humidity":
                        humidityStandard = weather.getGeneralConditions().getHumidity();
                    case "temperatureMin":
                        temperatureMinStandard = weather.getGeneralConditions().getTemperatureMin();
                    case "temperatureMax":
                        temperatureMaxStandard = weather.getGeneralConditions().getTemperatureMax();
                    case "seaLevelPressure":
                        seaLevelPressureStandard = weather.getGeneralConditions().getSeaLevelPressure();
                    case "groundLevelPressure":
                        groundLevelPressureStandard = weather.getGeneralConditions().getGroundLevelPressure();
                }

        }
    }

    @Then("feels like in metric and imperial are different")
    public void feelsLikeInMetricAndImperialAreDifferent() {
        Assert.assertFalse(feelsLikeMetric == feelsLikeImperial);
    }

    @Then("same pressure in metric and imperial are different")
    public void samePressureInMetricAndImperialAreDifferent() {
        Assert.assertTrue(pressureMetric == pressureImperial);
    }

    @Then("temperature in standard and imperial are different")
    public void temperatureInStandardAndImperialAreDifferent() {
        System.out.println(feelsLikeStandard);
        System.out.println(feelsLikeImperial);
        Assert.assertFalse(feelsLikeStandard == feelsLikeImperial);
    }

    @Then("country should be {string}")
    public void countryShouldBe(String country) {
        Assert.assertEquals(country,weather.getSystemInformation().getCountry());
    }

    @Then("temperature min in metric and imperial are different")
    public void temperatureMinInMetricAndImperialAreDifferent() {
        Assert.assertTrue(temperatureMinImperial != temperatureMinMetric);
    }

    @Then("temperature max in metric and imperial are different")
    public void temperatureMaxInMetricAndImperialAreDifferent() {
        Assert.assertTrue(temperatureMaxImperial != temperatureMaxMetric);
    }

    @And("I send HTTP request with {int} longitude and {int} latitude")
    public void iSendHTTPRequestWithLongitudeAndLatitude(int lon, int lat) {
        connectionManager.latLonApiCall(lon, lat);
    }

    @When("I set query param {string} as {string} with language as {string}")
    public void iSetQueryParamAsWithLanguageAs(String q, String city, String lang) {
        String s = connectionManager.cityApiCall(city,Languages.valueOf(lang.toUpperCase()));
        weather = injector.injectResponseToWeather(s);
    }

    @Given("the user with ID {string} for the API")
    public void theUserWithIDForTheAPI(String key) {
        this.apiKey = props.getProperty("apikey");
    }
}