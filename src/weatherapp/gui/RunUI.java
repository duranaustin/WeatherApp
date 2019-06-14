package weatherapp.gui;

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
