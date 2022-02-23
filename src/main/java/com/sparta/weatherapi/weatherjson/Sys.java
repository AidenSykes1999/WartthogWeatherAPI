package com.sparta.weatherapi.weatherjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys{

	@JsonProperty("country")
	private String country;

	@JsonProperty("sunrise")
	private int sunrise;

	@JsonProperty("sunset")
	private int sunset;

	public String getCountry(){
		return country;
	}

	public int getSunrise(){
		return sunrise;
	}

	public int getSunset(){
		return sunset;
	}

	@Override
	public String toString() {
		return "Sys{" +
				"country='" + country + '\'' +
				", sunrise=" + sunrise +
				", sunset=" + sunset +
				'}';
	}
}