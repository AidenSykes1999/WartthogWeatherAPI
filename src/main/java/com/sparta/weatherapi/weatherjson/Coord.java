package com.sparta.weatherapi.weatherjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord{

	@JsonProperty("lon")
	private int lon;

	@JsonProperty("lat")
	private int lat;

	public int getLon(){
		return lon;
	}

	public int getLat(){
		return lat;
	}

	@Override
	public String toString() {
		return "Coord{" +
				"lon=" + lon +
				", lat=" + lat +
				'}';
	}
}