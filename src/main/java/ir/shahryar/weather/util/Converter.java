package ir.shahryar.weather.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.shahryar.weather.weather.status.WeatherStatus;

public class Converter {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String toJson(WeatherStatus weatherStatus) {
        return gson.toJson(weatherStatus);
    }

    public static WeatherStatus fromJson(String json) {
        return gson.fromJson(json, WeatherStatus.class);
    }
}
