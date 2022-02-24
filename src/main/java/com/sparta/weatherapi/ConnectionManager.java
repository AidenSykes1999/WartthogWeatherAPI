package com.sparta.weatherapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConnectionManager {

    private int statusCode;

    public String latLonApiCall(Properties props, int latitude, int longitude) {

        String url = "http://api.openweathermap.org/data/2.5/weather?"
                + "lat=" + latitude + "&lon=" + longitude
                + "&appid=" + props.getProperty("apikey");

        HttpRequest request = createHttpRequest(url);

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

    public String cityApiCall(Properties props, String city) {

        String url = "http://api.openweathermap.org/data/2.5/weather?"
                + "q=" + city + "&appid=" + props.getProperty("apikey");

        HttpRequest request = createHttpRequest(url);

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
}
