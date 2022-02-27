package com.sparta.weatherapi.dtoweather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

	@JsonProperty("coord")
	private Coordinates coordinates;

	@JsonProperty("weather")
	private List<WeatherItem> weather;

	@JsonProperty("base")
	private String base;

	@JsonProperty("main")
	private GeneralConditions generalConditions;

	@JsonProperty("visibility")
	private int visibility;

	@JsonProperty("wind")
	private Wind wind;

	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("rain")
	private Rain rain;

	@JsonProperty("snow")
	private Snow snow;

	@JsonProperty("dt")
	private int dt;

	@JsonProperty("sys")
	private SystemInformation systemInformation;

	@JsonProperty("timezone")
	private int timezone;

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cod")
	private int cod;

	@JsonProperty("message")
	private String message;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public List<WeatherItem> getWeather() {
		return weather;
	}

	public String getBase() {
		return base;
	}

	public GeneralConditions getGeneralConditions() {
		return generalConditions;
	}

	public int getVisibility() {
		return visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public Rain getRain() {
		return rain;
	}

	public Snow getSnow() {
		return snow;
	}

	public int getDt() {
		return dt;
	}

	public SystemInformation getSystemInformation() {
		return systemInformation;
	}

	public int getTimezone() {
		return timezone;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Weather (" + name + "): {" +
				",\n coord: {" + coordinates + "}" +
				",\n weather: " + weather +
				",\n base: '" + base + '\'' +
				",\n conditions: {" + generalConditions + "}" +
				"\n visibility: " + visibility +
				",\n wind: {" + wind + "}" +
				",\n clouds: {" + clouds + "}" +
				",\n rain: {" + rain + "}" +
				",\n snow: {" + snow + "}" +
				",\n dt: " + dt +
				",\n sys: {" + systemInformation + "}" +
				",\n timezone: " + timezone +
				",\n id: " + id +
				",\n name: '" + name + '\'' +
				",\n cod: " + cod +
				", message: '" + message + '\'' +
				"\n}";
	}
}