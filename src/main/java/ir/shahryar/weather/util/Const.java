package ir.shahryar.weather.util;

public interface Const {
    String apiKey = "11cd02f5435e44679d374859210209";
    String apiCall = "http://api.weatherapi.com/%s/forecast.json?key=%s&q=%s&days=%d&aqi=no&alerts=no";
    String version = "v1";
}
