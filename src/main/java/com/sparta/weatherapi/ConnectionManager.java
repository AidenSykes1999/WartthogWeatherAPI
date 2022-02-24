package com.sparta.weatherapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConnectionManager {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
    private Properties props;

    private int statusCode;

    public ConnectionManager(Properties props) {
        this.props = props;
    }

    public String latLonApiCall(int latitude, int longitude) {

        String url = BASE_URL + "lat=" + latitude + "&lon=" + longitude
                + "&appid=" + getApiKeyString();

        String responseString = makeApiCall(url);

        return responseString;
    }

    // for state and country codes use 'https://www.iso.org/obp/ui/#home'
    public String cityApiCall(String city, String stateCode, String countryCode) {

        StringBuilder sb = new StringBuilder();

        String cityCleaned = replaceSpaces(city);
        String stateCodeCleaned = replaceSpaces(stateCode);
        String countryCodeCleaned = replaceSpaces(countryCode);

        sb.append(BASE_URL);
        sb.append("q=").append(cityCleaned);

        if (!stateCode.equals("")) {
            sb.append(",").append(stateCodeCleaned);
        }

        if (!countryCode.equals("")) {
            sb.append(",").append(countryCodeCleaned);
        }

        sb.append(getApiKeyString());

        String responseString = makeApiCall(sb.toString());

        return responseString;
    }

    public String cityApiCall(String city, String stateCode) {
        return cityApiCall(city, stateCode, "");
    }

    public String cityApiCall(String city) {
        return cityApiCall(city, "", "");
    }

    // for country codes use 'https://www.iso.org/obp/ui/#home'
    public String zipCodeApiCall(String zipCode, String countryCode) {

        StringBuilder sb = new StringBuilder();

        String zipCodeCleaned = replaceSpaces(zipCode);
        String countryCodeCleaned = replaceSpaces(zipCode);

        sb.append(BASE_URL);
        sb.append("zip=").append(zipCodeCleaned);

        if (countryCodeCleaned != "") {
            sb.append(",").append(countryCode);
        }

        sb.append(getApiKeyString());

        String responseString = makeApiCall(sb.toString());

        return responseString;

    }

    public String zipCodeApiCall(String zipCode) {
        return zipCodeApiCall(zipCode, "");
    }


    private String replaceSpaces(String spaceInput) {
        return spaceInput.replace(" ", "%20");
    }

    public String getApiKeyString() {
        return "&appid=" + props.getProperty("apikey");
    }

    private String makeApiCall(String url) {

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        String responseString = "";

        try{
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            responseString = response.body();
            this.statusCode = response.statusCode();

        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        return responseString;

    }

    public int getStatusCode() {
        return statusCode;
    }
}
