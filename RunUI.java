package weatherapp.gui;

import javafx.stage.Stage;

public class RunUI {
	private static Stage primaryStage;
	
    public static void main(String[] args) {
        try {
            WeatherUI gui = new WeatherUI();
            gui.start(primaryStage);
        } catch (Exception e) {
//            System.err.println("Error displaying WeatherUI");
            e.printStackTrace();
        }
    }
}
