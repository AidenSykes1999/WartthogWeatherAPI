package com.sparta.weatherapi.dtoweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemInformation {
	@JsonProperty("type")
	private int type;

	@JsonProperty("id")
	private int id;

	@JsonProperty("message")
	private String message;

	@JsonProperty("country")
	private String country;

	@JsonProperty("sunrise")
	private int sunrise;

	@JsonProperty("sunset")
	private int sunset;

	public int getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getCountry() {
		return country;
	}

	public int getSunrise() {
		return sunrise;
	}

	public int getSunset() {
		return sunset;
	}

	@Override
	public String toString() {
		return "SystemInformation: {" +
				"type: " + type +
				", id: " + id +
				", message: '" + message + '\'' +
				", country: '" + country + '\'' +
				", sunrise: " + sunrise +
				", sunset: " + sunset +
				'}';
	}
}