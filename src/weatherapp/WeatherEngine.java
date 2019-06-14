package weatherapp;

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

    /**
     * Upon object creation of WeatherEngine a WeatherAPI object is created  in order to populate WeatherEngine fields/instance variables
     * @throws Exception
     */
    public WeatherEngine() throws Exception {
        api = new WeatherAPI();//reach out to API
        monday = getMonday();
        //set all fields by parsing json file
    }

    private WeatherDay getMonday() {
        // use api object for weather info
        return new WeatherDay();
    }

}


