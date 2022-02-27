package com.sparta.weatherapi.dtoweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{

	@JsonProperty("speed")
	private double speed;

	@JsonProperty("deg")
	private int degree;

	@JsonProperty("gust")
	private double gust;

	public double getSpeed(){
		return speed;
	}

	public int getDegree(){
		return degree;
	}

	public double getGust(){
		return gust;
	}

	@Override
	public String toString() {
		return "Wind: {" +
				"speed: " + speed +
				", degree: " + degree  + "°" +
				", gust: " + gust +
				'}';
	}
}