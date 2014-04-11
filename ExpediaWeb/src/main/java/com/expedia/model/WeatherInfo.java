package com.expedia.model;

public class WeatherInfo {
private String city;
private String temp;

@Override
public String toString() {
	return "WeatherInfo [city=" + city + ", temp=" + temp + ", zipCode=" +"]";
}

public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getTemp() {
	return temp;
}
public void setTemp(String temp) {
	this.temp = temp;
}

}
