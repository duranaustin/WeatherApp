package weatherapp;

/**
 * Brains of weather app
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
    private Day day = new Day();
    public static WeatherDB db;
    public static WeatherAPI api;

    public WeatherEngine(String location) throws Exception {
        db = new WeatherDB(location); //reach out to database with location db = new WeatherDB(location);
        api = new WeatherAPI(location); //reach out to API with location api = new WeatherAPI(location);
        //set all fields by parsing json file
    }

    public class Day{
        private String day = null;
        private String dayFarenheitDegreeHigh = null;
        private String dayFarenheitDegreeLow = null;
        private String dayWeatherStatus = null;
    }



}


