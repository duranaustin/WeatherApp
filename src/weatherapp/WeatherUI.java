package weatherapp;

/**
 * Weather UI handles all of what the user sees in the WeatherApp
 */
public class WeatherUI {

    private WeatherEngine engine;

    /**
     * Upon object creation of WeatherUI a WeatherEngine object is created to enable access to all fields necessary for populating data in UI
     * @throws Exception
     */
    public WeatherUI() throws Exception {
        this.engine = new WeatherEngine();

    }

}
