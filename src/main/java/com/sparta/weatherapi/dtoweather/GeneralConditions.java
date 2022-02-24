package com.sparta.weatherapi.dtoweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralConditions {

	@JsonProperty("temp")
	private double temperature;

	@JsonProperty("feels_like")
	private double feelsLike;

	@JsonProperty("pressure")
	private int pressure;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("temp_min")
	private double temperatureMin;

	@JsonProperty("temp_max")
	private double temperatureMax;

	@JsonProperty("sea_level")
	private int seaLevelPressure;

	@JsonProperty("grnd_level")
	private int groundLevelPressure;

	public double getTemperature() {
		return temperature;
	}

	public double getFeelsLike() {
		return feelsLike;
	}

	public int getPressure() {
		return pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getTemperatureMin() {
		return temperatureMin;
	}

	public double getTemperatureMax() {
		return temperatureMax;
	}

	public int getSeaLevelPressure() {
		return seaLevelPressure;
	}

	public int getGroundLevelPressure() {
		return groundLevelPressure;
	}

	@Override
	public String toString() {
		return "GeneralConditions {" +
				"temperature: " + temperature +
				", feelsLike: " + feelsLike +
				", pressure: " + pressure + "hPa" +
				", humidity: " + humidity + "%" +
				", temperatureMin: " + temperatureMin +
				", temperatureMax: " + temperatureMax +
				", seaLevelPressure: " + seaLevelPressure + "hPa" +
				", groundLevelPressure: " + groundLevelPressure + "hPa" +
				'}';
	}
}