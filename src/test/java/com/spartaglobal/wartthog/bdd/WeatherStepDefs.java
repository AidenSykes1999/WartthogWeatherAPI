package com.spartaglobal.wartthog.bdd;

import io.cucumber.java.en.*;

public class WeatherStepDefs {

    @Given("the user with ID {string} for the API")
    public void the_user_with_id_for_the_api(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("I send {string} HTTP request")
    public void i_send_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("status code is {string}")
    public void status_code_is(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("I set Header param request {string} as {string}")
    public void iSetHeaderParamRequestAs(String arg0, String arg1) {
    }

    @When("I set query param {string} as {string}")
    public void iSetQueryParamAs(String arg0, String arg1) {
    }

    @And("I send {int} longitude and {int} latitude")
    public void i_send_lat_and_long(int latitude , int longitude ) {
    }



}
