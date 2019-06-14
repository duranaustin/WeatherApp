package weatherapp;

import javax.swing.text.Keymap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private String currentFarenheitDegree = null;
    private String currentWeatherStatus = null;
    private String currentFarenheitDegreeHigh = null;
    private String currentFarenheitDegreeLow = null;
    private String currentCity = null;
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

    /**
     * Upon object creation of WeatherEngine a WeatherAPI object is created  in order to populate WeatherEngine fields/instance variables
     * @throws Exception
     */
    public WeatherEngine() throws Exception {
        api = new WeatherAPI();//reach out to API
        setKeyMap();
        monday = getMonday();
        //TODO set all fields by parsing json file from src/resources/myfile.json
    }

    private void setKeyMap(){
        String json = this.api.response;

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            //Convert Map to JSON
            this.map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});

            //Print JSON output
            System.out.println(this.map);
            System.out.println(this.map.get("name"));
            System.out.println(this.map.get("main"));
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
