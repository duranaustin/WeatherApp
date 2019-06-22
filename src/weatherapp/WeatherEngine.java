package weatherapp;

import javax.swing.text.Keymap;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Brains of WeatherApp parses API data and provides fields for WeatherUI.java
 */
public class WeatherEngine {

    private String getRequest = null;
    private String getResponse = null;
    private String currentDay = null;
    private String currentFarenheitDegree;
    private String currentWeatherStatus;
    private String currentFarenheitDegreeHigh = null;
    private String currentFarenheitDegreeLow = null;
    private String currentCity;
    private String currentState = null;
    private WeatherDay monday;
    private WeatherDay tuesday;
    private WeatherDay wednesday;
    private WeatherDay thursday;
    private WeatherDay friday;
    private WeatherDay saturday;
    private WeatherDay sunday;
    private WeatherAPI api;
    public HashMap<String, Object> map;
    private String[] parts1;
    private String[] parts2;

    /**
     * Upon object creation of WeatherEngine a WeatherAPI object is created
     * in order to populate WeatherEngine fields/instance variables
     * @throws Exception Throws an exception if  WeatherEngine fails to run
     */
    public WeatherEngine() throws Exception {
        api = new WeatherAPI();//reach out to API
        setKeyMap();
        monday = getMonday();
        //TODO set all fields by parsing json file from src/resources/myfile.json

        // Testing mapParser method
        System.out.println();
        mapParser("name");
        mapParser("main");
        mapParser("weather");
    }

    private void setKeyMap(){
        String json = this.api.response;

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            //Convert Map to JSON
            this.map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});

            //Print JSON output
//            System.out.println(this.map);
//            System.out.println(this.map.get("name"));
//            System.out.println(this.map.get("main"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the string retrieved from the setKeyMap method map. Once the string is
     * retrieved it then goes through the jsonStringSplitter method to get split into
     * it's individual items.
     * TODO There may be another more efficient/simple way to get deeper into the JSON sections.
     * @param mapString The String that is used to look up a particular map value.
     */
    private void mapParser(String mapString) {
        String ss = this.map.get(mapString).toString();
        switch (mapString) {
            case "name":
                currentCity = this.map.get(mapString).toString();
                System.out.println(currentCity);
                break;
            case "main":
                jsonStringSplitter(ss);
                currentFarenheitDegree = parts2[1];
                System.out.println(currentFarenheitDegree);
                break;
            case "weather":
                jsonStringSplitter(ss);
                currentWeatherStatus = parts2[5];
                System.out.println(currentWeatherStatus);
                break;
        }
    }

    /**
     * Splits the string that is retrieved from mapParser method and puts them in a String[].
     *
     * @param ss The String that is going to be split.
     */
    private void jsonStringSplitter(String ss) {
        StringBuilder sb = new StringBuilder();
        parts1 = ss.split(", ");
        for (String s : parts1) {
            sb.append(s).append("=");
        }
        sb.deleteCharAt(sb.length() - 2);
        String t = sb.toString();

        parts2 = t.split("=");
    }

    private WeatherDay getMonday() {
        //TODO use api object for weather info
        return new WeatherDay();

    }

    private WeatherDay getTuesday() {

        return new WeatherDay();
    }

    private  WeatherDay getWednesday() {

        return new WeatherDay();
    }

    private WeatherDay getThursday() {

        return new WeatherDay();
    }

    private WeatherDay getFriday() {

        return new WeatherDay();

    }

    private WeatherDay getSaturday() {

        return new WeatherDay();
    }

    private WeatherDay getSunday() {

        return new WeatherDay();
    }
}
