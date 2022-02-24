package com.sparta.weatherapi.weatherjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {

    @JsonProperty("1h")
    private double oneHour;

    @JsonProperty("3h")
    private double threeHour;

    public double getOneHour() {
        return oneHour;
    }

    public double getThreeHour() {
        return threeHour;
    }

    @Override
    public String toString() {
        return "Snow: " +
                "oneHour: " + oneHour +
                ", threeHour: " + threeHour +
                '}';
    }
}
