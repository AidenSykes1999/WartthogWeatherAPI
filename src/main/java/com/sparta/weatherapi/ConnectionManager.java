package com.sparta.weatherapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConnectionManager {

    private int statusCode;

    public final String url =  "http://api.openweathermap.org/data/2.5/weather?";

    public String ApiCall(String uri) {

        HttpRequest request = createHttpRequest(uri);

        HttpClient httpClient = HttpClient.newHttpClient();
        String responseString = "";

        try{
            HttpResponse<String> response =
                    httpClient.send(request,HttpResponse.BodyHandlers.ofString());

            responseString = response.body();
            this.statusCode = response.statusCode();

        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        return responseString;
    }

    private HttpRequest createHttpRequest(String url) {
        return HttpRequest.newBuilder().uri(URI.create(url)).build();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseByCity(String city, Properties props){
        String uri = url + "q=" + city + "&appid=" + props.getProperty("apikey");
        return ApiCall(uri);
    }

    public String getResponseByLatLon(int lat, int lon, Properties props){
        String uri = url + "lat=" + lat + "&lon=" + lon + "&appid=" + props.getProperty("apikey");
        return ApiCall(uri);
    }

    public String getResponseByZipCountryCode(String zipCode, String countryCode, Properties props){
        String uri = url + "zip=" + zipCode + "," + countryCode + "&appid=" + props.getProperty("apikey");
        return ApiCall(uri);
    }


}
