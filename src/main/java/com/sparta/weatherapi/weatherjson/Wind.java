package com.sparta.weatherapi.weatherjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{

	@JsonProperty("deg")
	private int deg;

	@JsonProperty("speed")
	private double speed;

	@JsonProperty("gust")
	private double gust;

	public int getDeg(){
		return deg;
	}

	public double getSpeed(){
		return speed;
	}

	public double getGust(){
		return gust;
	}

	@Override
	public String toString() {
		return "Wind{" +
				"deg=" + deg +
				", speed=" + speed +
				", gust=" + gust +
				'}';
	}
}