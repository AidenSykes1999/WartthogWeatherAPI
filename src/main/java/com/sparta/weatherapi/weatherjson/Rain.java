package com.sparta.weatherapi.weatherjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

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
        return "Rain: " +
                "oneHour: " + oneHour +
                ", threeHour: " + threeHour +
                '}';
    }
}
