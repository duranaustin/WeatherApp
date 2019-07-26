package weatherapp.gui;

/**
 * RunUI puts the Weather App in motion
 */
public class RunUI {

    public static void main(String[] args) {
        try {
            WeatherUI gui = new WeatherUI();
            gui.showMainFrame();


        } catch (Exception e) {
            System.err.println("Error displaying WeatherUI");
            e.printStackTrace();
        }
    }
}
