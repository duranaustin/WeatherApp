package weatherapp;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

/**
 *
 * WeatherAPI sends a get request to our created API which notes our IP address and sends us back the respective Weather Info for our IP address location
 *
 * EXAMPLE: https://api.weather.gov
 * *** SLC *** https://api.weather.gov/points/39.4192,-111.9507
 * *** SLC Forecast *** https://api.weather.gov/gridpoints/SLC/90,114/forecast
 * EXAMPLE: our api
 * !Use this url: (same url server calls but id=$###### will be generated based on user ip)
 *      api.openweathermap.org/data/2.5/forecast?id=$5781770&appid=3047a788b7d827644b13600e4d46ab7b
 *
 * *** website : ec2-18-222-251-236.us-east-2.compute.amazonaws.com
 * *** website/json : http://ec2-18-222-251-236.us-east-2.compute.amazonaws.com/currentweather.json
 */
public class WeatherAPI {
    private HashMap<String, HashMap<String, ArrayList>> weatherData;

    private ObjectMapper objectMapper = new ObjectMapper();
    private TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>(){};
    private URL url = new URL("http://ec2-18-222-251-236.us-east-2.compute.amazonaws.com/localweather.php");
    private File file = new File("src/weatherapp/resources/localWeatherForecast.json");

    public static void main(String[] args) throws Exception {
//        WeatherAPI weatherAPI = new WeatherAPI();
//        Object o = weatherAPI.getJsonWeather();
    }
    /**
     * Upon object creation WeatherAPI immediately uses getJsonWeather() to send a get request to our created API
     * @throws Exception Throws an exception if the getJsonWeather and setJsonFile methods do not work.
     */
    public WeatherAPI() throws Exception {
        getJsonWeather();
    }

    /**
     * Gets Weather information based off of the OpenWeatherMap API
     * Uses our API key 3047a788b7d827644b13600e4d46ab7b
     * @throws Exception If the weather connection cannot be established, an exception is thrown.
     *
     * if url throws a FileNotFoundException try getting file saved in resources
     */

    public HashMap<String, HashMap<String, ArrayList>> getJsonWeather() throws Exception {
        try {
            /**
             * Set weatherData object to json dataset (url or file ).
             * Return weatherData object.
             */
            if (responseCode() != 200){
                    this.weatherData = objectMapper.readValue(file, typeRef);
                    return weatherData;
            } else{
                this.weatherData = objectMapper.readValue(url, typeRef);
                setJsonFile(this.weatherData);
                return weatherData;
            }
        } catch (IOException e) {
            System.err.println("Weather connection error in WeatherAPI.getJsonWeather()");
            e.printStackTrace();
        }
        return weatherData;
    }

    /**
     * Writes JSON file to src/resources/myfile.json using response from getJsonWeather()
     * @throws IOException If the file cannot be written, and exception is thrown.
     */
    public void setJsonFile(Object o) throws IOException {
        try (FileWriter writer = new FileWriter("src\\weatherapp\\resources\\localWeatherForecast.json")) {
            objectMapper.writeValue(writer, o);
            System.out.println("Wrote to file.");
        }
    }

    public int responseCode() throws Exception{
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.connect();
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        return responseCode;
    }
}