package weatherapp;

import javax.swing.text.Keymap;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Brains of WeatherApp parses API data and provides fields for WeatherUI.java
 */
public class WeatherEngine {
    public static void main(String[] args) throws Exception {
        WeatherEngine weatherEngine = new WeatherEngine();
    }

    private WeatherAPI api;
    private HashMap<String, HashMap<String, ArrayList>> weatherData;
    private String currentCity;
    private List<WeatherForecast> forecastList = new ArrayList<>();

    private String currentDay = null;

    /**
     * Upon object creation of WeatherEngine a WeatherAPI object is created
     * in order to populate WeatherEngine fields/instance variables
     * and build an array list of weatherForcast objects with all fields set
     * TODO test for type exceptions and nullability of fields
     * @throws Exception Throws an exception if  WeatherEngine fails to run
     */
    public WeatherEngine() throws Exception {
        api = new WeatherAPI();//instantiate class
        weatherData = api.getJsonWeather(); //get weatherData Json HashMap and its nested data
    }

    public void setWeatherForecast(){
        HashMap<String, Object> city =(HashMap) weatherData.get("city");
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


            /*
             * these are unsafe calls and should be updated later
             * testing for typecasting, most values need to be Double but if the
             * api has a whole number it gets cast as type Integer.
             * it may also be null if not assigned im not sure
             */
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
    public void testForecastList(){
        for(int i = 0; i < forecastList.size(); i++){
            System.out.println(forecastList.get(i).toString());
        }
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public List<WeatherForecast> getForcastList() {
        //TODO use api object for weather info
        return forecastList;

    }
}
