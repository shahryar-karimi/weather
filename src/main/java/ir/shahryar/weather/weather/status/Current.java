package ir.shahryar.weather.weather.status;

import ir.shahryar.weather.weather.status.forecast.forecastday.Condition;

public class Current {
    public long last_updated_epoch;
    public String last_updated;
    public double temp_c;
    public int is_day;
    public Condition condition;
    public double wind_kph;
    public int wind_degree;
    public String wind_dir;
    public double pressure_mb;
    public double pressure_in;
    public double precip_mm;
    public double precip_in;
    public int humidity;
    public int cloud;
    public double feelslike_c;
    public double vis_km;
    public double uv;
    public double gust_kph;
}
