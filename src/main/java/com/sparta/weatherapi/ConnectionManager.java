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

    public String latLonApiCall(int latitude, int longitude, Units units, Languages language) {

        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL);
        sb.append("lat=").append(latitude);
        sb.append("&lon=").append(longitude);

        sb.append(getUnitsLanguageParameters(units, language));
        sb.append(getApiKeyString());

        return makeApiCall(sb.toString());
    }

    public String latLonApiCall(int latitude, int longitude, Languages language) {
        return latLonApiCall(latitude, longitude, Units.NONE, language);
    }

    public String latLonApiCall(int latitude, int longitude, Units units) {
        return latLonApiCall(latitude, longitude, units, Languages.NONE);
    }

    public String latLonApiCall(int latitude, int longitude) {
        return latLonApiCall(latitude, longitude, Units.NONE, Languages.NONE);
    }

    // for state and country codes use 'https://www.iso.org/obp/ui/#home'
    public String cityApiCall(String city, String stateCode, String countryCode, Units units, Languages language) {

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

        sb.append(getUnitsLanguageParameters(units, language));
        sb.append(getApiKeyString());

        return makeApiCall(sb.toString());
    }

    public String cityApiCall(String city, String stateCode, String countryCode, Languages language) {
        return cityApiCall(city, stateCode, countryCode, Units.NONE, language);
    }

    public String cityApiCall(String city, String stateCode, String countryCode, Units units) {
        return cityApiCall(city, stateCode, countryCode, units, Languages.NONE);
    }

    public String cityApiCall(String city, String stateCode, String countryCode) {
        return cityApiCall(city, stateCode, countryCode, Units.NONE, Languages.NONE);
    }

    public String cityApiCall(String city, String stateCode, Units units, Languages language) {
        return cityApiCall(city, stateCode, "", units,  language);
    }

    public String cityApiCall(String city, String stateCode, Languages language) {
        return cityApiCall(city, stateCode, "", Units.NONE,  language);
    }

    public String cityApiCall(String city, String stateCode, Units units) {
        return cityApiCall(city, stateCode, "", units,  Languages.NONE);
    }

    public String cityApiCall(String city, String stateCode) {
        return cityApiCall(city, stateCode, "", Units.NONE, Languages.NONE);
    }

    public String cityApiCall(String city, Units units, Languages language) {
        return cityApiCall(city, "", "", units, language);
    }

    public String cityApiCall(String city, Languages language) {
        return cityApiCall(city, "", "", Units.NONE, language);
    }

    public String cityApiCall(String city, Units units) {
        return cityApiCall(city, "", "", units, Languages.NONE);
    }

    public String cityApiCall(String city) {
        return cityApiCall(city, "", "", Units.NONE, Languages.NONE);
    }

    public String cityIDApiCall(String cityID, Units units, Languages language) {

        StringBuilder sb = new StringBuilder();

        String cityIDCleaned = replaceSpaces(cityID);

        sb.append(BASE_URL);
        sb.append("id=").append(cityIDCleaned);

        sb.append(getUnitsLanguageParameters(units, language));
        sb.append(getApiKeyString());

        return makeApiCall(sb.toString());
    }

    public String cityIDApiCall(String cityID, Languages language) {
        return cityIDApiCall(cityID, Units.NONE, language);
    }

    public String cityIDApiCall(String cityID, Units units) {
        return cityIDApiCall(cityID, units, Languages.NONE);
    }

    public String cityIDApiCall(String cityID) {
        return cityIDApiCall(cityID, Units.NONE, Languages.NONE);
    }

    // for country codes use 'https://www.iso.org/obp/ui/#home'
    public String zipCodeApiCall(String zipCode, String countryCode, Units units, Languages language) {

        StringBuilder sb = new StringBuilder();

        String zipCodeCleaned = replaceSpaces(zipCode);
        String countryCodeCleaned = replaceSpaces(zipCode);

        sb.append(BASE_URL);
        sb.append("zip=").append(zipCodeCleaned);

        if (!countryCodeCleaned.equals("")) {
            sb.append(",").append(countryCode);
        }

        sb.append(getUnitsLanguageParameters(units, language));
        sb.append(getApiKeyString());

        return makeApiCall(sb.toString());

    }

    public String zipCodeApiCall(String zipCode, String countryCode, Languages language) {
        return zipCodeApiCall(zipCode, countryCode, Units.NONE, language);
    }

    public String zipCodeApiCall(String zipCode, String countryCode, Units units) {
        return zipCodeApiCall(zipCode, countryCode, units, Languages.NONE);
    }

    public String zipCodeApiCall(String zipCode, String countryCode) {
        return zipCodeApiCall(zipCode, countryCode, Units.NONE, Languages.NONE);
    }

    public String zipCodeApiCall(String zipCode, Units units, Languages language) {
        return zipCodeApiCall(zipCode, "", units, language);
    }

    public String zipCodeApiCall(String zipCode, Languages language) {
        return zipCodeApiCall(zipCode, "", Units.NONE, language);
    }

    public String zipCodeApiCall(String zipCode, Units units) {
        return zipCodeApiCall(zipCode, "", units, Languages.NONE);
    }

    public String zipCodeApiCall(String zipCode) {
        return zipCodeApiCall(zipCode, "", Units.NONE, Languages.NONE);
    }

    private String replaceSpaces(String spaceInput) {
        return spaceInput.replace(" ", "%20");
    }

    private String getUnitsLanguageParameters(Units units, Languages language) {

        StringBuilder sb = new StringBuilder();

        if (units != Units.NONE) {
            sb.append("&units=").append(units.apiValue);
        }
        if (language != Languages.NONE) {
            sb.append("&lang=").append(language.apiValue);
        }

        return sb.toString();
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
