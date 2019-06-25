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

//        monday = getMonday();
        //TODO set all fields by parsing json file from src/resources/myfile.json
        // Testing mapParser method
        setWeatherForecast();
        testForcastList();
    }

    private void setWeatherForecast(){
        ArrayList fullWeek = (ArrayList) ((Object) weatherData.get("list"));
        for(int i = 0; i < fullWeek.size(); i++){
            HashMap<String, HashMap<String, Object>> instanceForecast = (HashMap) ((Object) fullWeek.get(i));

            WeatherForecast weatherForecast = new WeatherForecast();

            String date = (String)((Object) instanceForecast.get("dt_txt"));

            /**
             * these are unsafe calls and should be updated later
             * testing for typecasting, most values need to be Double but if the
             * api has a whole number it gets cast as type Integer.
             * it may also be null if not assigned im not sure
             */
            System.out.println(instanceForecast.get("main").get("humidity") + " " + instanceForecast.get("main").get("humidity").getClass());
            weatherForecast.setDate((String)((Object) instanceForecast.get("dt_txt")));
            weatherForecast.setHumidity((Integer) instanceForecast.get("main").get("humidity"));

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

            if(instanceForecast.get("main").get("speed") instanceof Integer){
                weatherForecast.setWind_speed((double)((Integer) instanceForecast.get("wind").get("speed")));
            }else {
                weatherForecast.setWind_speed((Double) instanceForecast.get("wind").get("speed"));
            }

            if(instanceForecast.get("main").get("deg") instanceof Integer){
                weatherForecast.setWind_deg((double)((Integer) instanceForecast.get("wind").get("deg")));
            }else {
                weatherForecast.setWind_deg((Double) instanceForecast.get("wind").get("deg"));
            }

            forecastList.add(weatherForecast);
        }
    }
    private void testForcastList(){
        for(int i = 0; i < forecastList.size(); i++){
            System.out.println("Date: " + forecastList.get(i).getDate() +
                    "\nTemp: " + forecastList.get(i).getTemp() +
                    "\nTemp min: " + forecastList.get(i).getTemp_max() +
                    "\nTemp max: " + forecastList.get(i).getTemp_max() +
                    "\nPressure: " + forecastList.get(i).getPressure() +
                    "\nSea Level: " + forecastList.get(i).getSea_level() +
                    "\nGround Level: " + forecastList.get(i).getGrnd_level() +
                    "\nHumidity: " + forecastList.get(i).getHumidity() +
                    "\nTemp kf: " + forecastList.get(i).getTemp_kf() +
                    "\nwind speed: " + forecastList.get(i).getWind_speed() +
                    "\nwind Direction: " + forecastList.get(i).getWind_deg() +
                    "\nDescription: " + forecastList.get(i).getDescription() +
                    "\n\n");
        }
    }

    private WeatherForecast getMonday() {
        //TODO use api object for weather info
        return new WeatherForecast();

    }
}
