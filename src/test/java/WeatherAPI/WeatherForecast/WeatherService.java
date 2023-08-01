package WeatherAPI.WeatherForecast;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherService {
    private static final String BASE_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

    public float getWeatherForDate(String date) {
        Response response = RestAssured.get(BASE_URL);
        Object value = response.path("list.find { it.dt_txt.startsWith('" + date + "') }.main.temp");
        return value != null ? ((Number) value).floatValue() : 0.0f;
    }

    public float getWindSpeedForDate(String date) {
        Response response = RestAssured.get(BASE_URL);
        Object value = response.path("list.find { it.dt_txt.startsWith('" + date + "') }.wind.speed");
        return value != null ? ((Number) value).floatValue() : 0.0f;
    }

    public float getPressureForDate(String date) {
        Response response = RestAssured.get(BASE_URL);
        Object value = response.path("list.find { it.dt_txt.startsWith('" + date + "') }.main.pressure");
        return value != null ? ((Number) value).floatValue() : 0.0f;
    }
}



