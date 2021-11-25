package ir.shahryar.weather.weather;

import ir.shahryar.weather.util.Const;
import ir.shahryar.weather.util.Converter;
import ir.shahryar.weather.weather.status.WeatherStatus;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    public WeatherStatus getStatus(String city, int days) {
        WeatherStatus weatherStatus = null;
        Request request = createRequest(city, days);
        Response response = getResponse(request);
        ResponseBody body = response.body();
        if (body != null) {
            try {
                weatherStatus = Converter.fromJson(body.string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Body is empty");
        }
        return weatherStatus;
    }

    public Request createRequest(String city, int days) {
        String finalUrl = String.format(Const.apiCall, Const.version, Const.apiKey, city, days);
        return new Request.Builder()
                .url(finalUrl)
                .build();
    }

    public Response getResponse(Request request) {
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
