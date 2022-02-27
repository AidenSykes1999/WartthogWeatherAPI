package com.sparta.weatherapi.dtoweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {

	@JsonProperty("lon")
	private int longitude;

	@JsonProperty("lat")
	private int latitude;

	public int getLongitude(){
		return longitude;
	}

	public int getLatitude(){
		return latitude;
	}

	@Override
	public String toString() {
		return "Coordinates: {" +
				"longitude: " + longitude + "°" +
				", latitude: " + latitude + "°" +
				'}';
	}
}