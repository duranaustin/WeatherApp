package weatherapp.gui;

import weatherapp.WeatherEngine;
import weatherapp.WeatherForecast;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class WeatherUI extends JFrame {
    private WeatherEngine engine;

    private JPanel mainFrame;
    private JButton btnOne;
    private JPanel mainPanel;
    private JLabel lblHello;
    private JPanel subPanel;
    private List<WeatherForecast> forecastList;

    public WeatherUI() throws Exception {

        mainPanel.updateUI();
        subPanel.updateUI();
        createBtnOne();

    }

    public void showMainFrame() throws Exception {
        JFrame frame = new JFrame("Weather App");
        frame.setContentPane(new WeatherUI().mainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        setLocationRelativeTo(null);
        frame.setVisible(true);



        this.engine = new WeatherEngine();
        engine.setWeatherForecast();
        forecastList = engine.getForcastList();
        System.out.println("\nexample usage of forecastList in WeatherUI.showMainFrame(). \n\n");
        System.out.println("Weekend Forecast for " + engine.getCurrentCity() + ": \n");
        for (int i = 0; i < forecastList.size(); i++){
            String weekday = forecastList.get(i).getWeekday();
            if((weekday.equals("Thursday")) || weekday.equals("Friday") || weekday.equals("Saturday") || weekday.equals("Sunday")){
                System.out.println( "DateTime: " + forecastList.get(i).getWeekday() + " " + forecastList.get(i).getDate() + ", Temp min: "
                        + forecastList.get(i).getTemp_min() + ", Temp max: "
                        + forecastList.get(i).getTemp_max() + ", Status: " + forecastList.get(i).getDescription());
            }
        }
        System.out.println("TODO: convert GMT to our timezone time(its printing in Greenwich Mean Time, which is standard, it just needs a timezone). \nAdd current weather: new php file, extra url call in api, new weather object, new parsing methods.");



    }

    private void createBtnOne() {
        btnOne.addActionListener(actionEvent -> lblHello.setVisible(true));
    }
}
