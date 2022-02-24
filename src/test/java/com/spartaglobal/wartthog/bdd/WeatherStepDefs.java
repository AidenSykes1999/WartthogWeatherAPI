package com.spartaglobal.wartthog.bdd;

import com.sparta.weatherapi.ConnectionManager;
import com.sparta.weatherapi.Injector;
import com.sparta.weatherapi.dtoweather.Weather;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
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

    @Before
    public void setUp(){
        props = new Properties();

        try {
            props.load(new FileReader("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        connectionManager = new ConnectionManager();
        injector = new Injector();
    }

    @Given("the user with ID {string} for the API")
    public void the_user_with_id_for_the_api(String string) {
        apiKey = props.getProperty("apikey");
    }


    @When("I send {string} HTTP request")
    public void i_send_http_request(String string) {
    }
    @Then("status code is {int}")
    public void status_code_is(int statusCode) {
        Weather weather = injector.injectResponseToWeather(connectionCity);
        System.out.println(weather.toString());
        Assert.assertEquals(statusCode, weather.getCod());
    }

    @When("I set Header param request {string} as {string}")
    public void iSetHeaderParamRequestAs(String arg0, String arg1) {
    }

    @When("I set query param {string} as {string}")
    public void iSetQueryParamAs(String arg0, String arg1) {
        connectionCity = connectionManager.cityApiCall(props, arg1);
    }

    @And("I send {int} longitude and {int} latitude")
    public void i_send_lat_and_long(int latitude , int longitude ) {
    }



}