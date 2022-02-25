package com.sparta.weatherapi.dtoweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

    @JsonProperty("1h")
    private double oneHourVolume;

    @JsonProperty("3h")
    private double threeHourVolume;

    public double getOneHourVolume() {
        return oneHourVolume;
    }

    public double getThreeHourVolume() {
        return threeHourVolume;
    }

    @Override
    public String toString() {
        return "Rain: {" +
                "oneHourVolume: " + oneHourVolume + "mm" +
                ", threeHourVolume: " + threeHourVolume + "mm" +
                '}';
    }
}
