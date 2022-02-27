package com.sparta.weatherapi.dtoweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds{

	@JsonProperty("all")
	private int cloudinessPercent;

	public int getCloudinessPercent(){
		return cloudinessPercent;
	}

	@Override
	public String toString() {
		return "Clouds: {" +
				"cloudinessPercent: " + cloudinessPercent + "%" +
				'}';
	}
}