package weatherapp;

import javax.swing.text.Keymap;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Brains of WeatherApp parses API data and provides fields for WeatherUI.java
 */
public class WeatherEngine {
    public static void main(String[] args) throws Exception {
//        WeatherEngine weatherEngine = new WeatherEngine();
    }

    private WeatherAPI api;
    private HashMap<String, HashMap<String, ArrayList>> weatherData;
    private String currentCity;
    private List<WeatherForecast> forecastList = new ArrayList<>();
    private WeatherCurrent weatherCurrent;

    private String currentDay = null;

    /**
     * Upon object creation of WeatherEngine a WeatherAPI object is created
     * in order to populate WeatherEngine fields/instance variables
     * and build an array list of weatherForcast objects with all fields set
     * TODO test for type exceptions and nullability of fields
     * @throws Exception Throws an exception if  WeatherEngine fails to run
     */
    public WeatherEngine() { }

    public void setWeatherForecast() throws Exception{
        api = new WeatherAPI();//instantiate class
        weatherData = api.getJsonWeather(new URL("http://ec2-18-222-251-236.us-east-2.compute.amazonaws.com/forecast.php?TYPE=forecast"), new File("src/weatherapp/resources/localWeatherForecast.json")); //get weatherData Json HashMap and its nested data
        HashMap<String, Object> city = (HashMap) weatherData.get("city");
        currentCity = city.get("name").toString();
        ArrayList fullWeek = (ArrayList) ((Object) weatherData.get("list"));
        for(int i = 0; i < fullWeek.size(); i++){
            WeatherForecast weatherForecast = new WeatherForecast();

            HashMap<String, HashMap<String, Object>> instanceForecast = (HashMap) ((Object) fullWeek.get(i));
            ArrayList weather = (ArrayList) ((Object) instanceForecast.get("weather"));
            HashMap<String,Object> description = (HashMap) (weather.get(0));

            Integer time = (Integer) ((Object) instanceForecast.get("dt"));
            String weekday = new SimpleDateFormat("EEEE").format((time) *1000L);
            String dt_txt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((time) * 1000L);


            weatherForecast.setDescription((String) description.get("description"));
            weatherForecast.setIcon((String) description.get("icon"));
            weatherForecast.setDate(dt_txt);
            weatherForecast.setHumidity((Integer) instanceForecast.get("main").get("humidity"));
            weatherForecast.setTime((Integer) ((Object) instanceForecast.get("dt")));
            weatherForecast.setWeekday(weekday);

            if(instanceForecast.get("main").get("temp") instanceof Integer){
                weatherForecast.setTemp((double) ((Integer) instanceForecast.get("main").get("temp")));
            }else{
                weatherForecast.setTemp((Double) instanceForecast.get("main").get("temp"));
            }


            if(instanceForecast.get("main").get("temp_max") instanceof Integer){
                weatherForecast.setTemp_max((double) ((Integer) instanceForecast.get("main").get("temp_max")));
            }else{
                weatherForecast.setTemp_max((Double) instanceForecast.get("main").get("temp_max"));
            }

            if(instanceForecast.get("main").get("temp_min") instanceof Integer){
                weatherForecast.setTemp_min((double) ((Integer) instanceForecast.get("main").get("temp_min")));
            }else{
                weatherForecast.setTemp_min((Double) instanceForecast.get("main").get("temp_min"));
            }

            if(instanceForecast.get("main").get("pressure") instanceof Integer){
                weatherForecast.setPressure((double) ((Integer) instanceForecast.get("main").get("pressure")));
            }else{
                weatherForecast.setPressure((Double) instanceForecast.get("main").get("pressure"));
            }

            if(instanceForecast.get("main").get("sea_level") instanceof Integer){
                weatherForecast.setSea_level((double)((Integer) instanceForecast.get("main").get("sea_level")));
            }else {
                weatherForecast.setSea_level((Double) instanceForecast.get("main").get("sea_level"));
            }

            if(instanceForecast.get("main").get("grnd_level") instanceof Integer){
                weatherForecast.setGrnd_level((double)((Integer) instanceForecast.get("main").get("grnd_level")));
            }else {
                weatherForecast.setGrnd_level((Double) instanceForecast.get("main").get("grnd_level"));
            }

            if(instanceForecast.get("main").get("temp_kf") instanceof Integer){
                weatherForecast.setTemp_kf((double)((Integer) instanceForecast.get("main").get("temp_kf")));
            }else {
                weatherForecast.setTemp_kf((Double) instanceForecast.get("main").get("temp_kf"));
            }

            if(instanceForecast.get("wind").get("speed") instanceof Integer){
                weatherForecast.setWind_speed((double)((Integer) instanceForecast.get("wind").get("speed")));
            }else {
                weatherForecast.setWind_speed((Double) instanceForecast.get("wind").get("speed"));
            }

            if(instanceForecast.get("wind").get("deg") instanceof Integer){
                weatherForecast.setWind_deg((double)((Integer) instanceForecast.get("wind").get("deg")));
            }else {
                weatherForecast.setWind_deg((Double) instanceForecast.get("wind").get("deg"));
            }

            forecastList.add(weatherForecast);
        }
    }

    public void setWeatherCurrent() throws Exception{
        weatherCurrent = new WeatherCurrent();
        api = new WeatherAPI();//instantiate class

        HashMap<String, Object> weather =(HashMap) api.getJsonWeather(new URL("http://ec2-18-222-251-236.us-east-2.compute.amazonaws.com/forecast.php?TYPE=weather"), new File("src/weatherapp/resources/localWeatherCurrent.json"));

        HashMap<String,Object> w = (HashMap<String, Object>) ((ArrayList) weather.get("weather")).get(0);

        String we = (String) w.get("description");

        weatherCurrent.setDescription(we);
        weatherCurrent.setDescription((String) ((HashMap<String, Object>) ((ArrayList) weather.get("weather")).get(0)).get("description"));
        weatherCurrent.setIcon((String) ((HashMap<String, Object>) ((ArrayList) weather.get("weather")).get(0)).get("icon"));
        weatherCurrent.setCity((String) weather.get("name"));
        weatherCurrent.setDt((Integer) weather.get("dt"));

        Integer time = (Integer) weather.get("dt");
        String weekday = new SimpleDateFormat("EEEE").format((time) *1000L);
        String date = new SimpleDateFormat("MM-dd-yyyy").format((time) * 1000L);
        String t = new SimpleDateFormat("hh:mm a").format((time) * 1000L);
        weatherCurrent.setDate(date);
        weatherCurrent.setTime(t);
        weatherCurrent.setWeekday(weekday);

        HashMap<String, Object> main = (HashMap<String, Object>) weather.get("main");
        main.get("temp");

        if(main.get("temp") instanceof Integer){
            weatherCurrent.setTemp((double) ((Integer) main.get("temp")));
        }else{
            weatherCurrent.setTemp((Double) main.get("temp"));
        }

        if(main.get("temp_max") instanceof Integer){
            weatherCurrent.setTemp_max((double) ((Integer) main.get("temp_max")));
        }else{
            weatherCurrent.setTemp_max((Double) main.get("temp_max"));
        }

        if(main.get("temp_min") instanceof Integer){
            weatherCurrent.setTemp_min((double) ((Integer) main.get("temp_min")));
        }else{
            weatherCurrent.setTemp_min((Double) main.get("temp_min"));
        }

        if(main.get("pressure") instanceof Integer){
            weatherCurrent.setPressure((double) ((Integer) main.get("pressure")));
        }else{
            weatherCurrent.setPressure((Double) main.get("pressure"));
        }

        if(main.get("humidity") instanceof Integer){
            weatherCurrent.setHumidity((double) ((Integer) main.get("humidity")));
        }else{
            weatherCurrent.setHumidity((Double) main.get("humidity"));
        }
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public WeatherCurrent getCurrentWeather() {
        return weatherCurrent;
    }

    public List<WeatherForecast> getForecastList() {
        //TODO use api object for weather info
        return forecastList;

    }
}
