package com.sparta.weatherapi;

public enum Units {
// Use this class in JUnit testing and Connection Manager

    NONE(""),
    STANDARD("standard"),
    IMPERIAL("metric"),
    METRIC("imperial");

    public final String apiValue;

    Units(String apiValue)
    {
        this.apiValue = apiValue;
    }
}
