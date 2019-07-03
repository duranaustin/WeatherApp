package weatherapp.gui;

import weatherapp.WeatherEngine;
import weatherapp.WeatherForecast;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherUI extends JFrame {
    private WeatherEngine engine;

    private JPanel mainFrame;
    private JPanel mainPanel;
    private JScrollPane forecastCardHolder;
    private JPanel cardHolder;
    private JPanel fiveDaySummary;
    private JPanel card;
    private JTextPane cardText;

    private List<WeatherForecast> forecastList;
    private Object next;

    public WeatherUI() throws Exception {
        mainFrame.updateUI();
        mainPanel.updateUI();
        forecastCardHolder.updateUI();
        cardHolder.updateUI();
        fiveDaySummary.updateUI();
        System.out.println("execute once");
    }

    public void showMainFrame() throws Exception {
        JFrame frame = new JFrame("Weather App");
        frame.setContentPane(mainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        setLocationRelativeTo(null);


<<<<<<< Updated upstream
        this.engine = new WeatherEngine();
        engine.setWeatherForecast();
        forecastList = engine.getForcastList();
=======



        createUIComponents();



        frame.setVisible(true);
>>>>>>> Stashed changes
        System.out.println("\nexample usage of forecastList in WeatherUI.showMainFrame(). \n\n");
        System.out.println("Weekend Forecast for " + engine.getCurrentCity() + ": \n");
        for (int i = 0; i < forecastList.size(); i++){
            String weekday = forecastList.get(i).getWeekday();
            if((weekday.equals("Thursday")) || weekday.equals("Friday") || weekday.equals("Saturday") || weekday.equals("Sunday")){
                System.out.println( "DateTime: " + forecastList.get(i).getWeekday() + " " + forecastList.get(i).getDate() + ", Temp: "
                        + forecastList.get(i).getTemp_max() + ", Status: " + forecastList.get(i).getDescription());
            }
        }
        System.out.println("TODO: convert GMT to our timezone time(its printing in Greenwich Mean Time, which is standard, it just needs a timezone). \nAdd current weather: new php file, extra url call in api, new weather object, new parsing methods.");


<<<<<<< Updated upstream
=======


    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
>>>>>>> Stashed changes
    }

    private void createUIComponents() throws Exception {
        // TODO: place custom component creation code here
        this.engine = new WeatherEngine();
        engine.setWeatherForecast();
        forecastList = engine.getForcastList();
        for(int i = 0; i <forecastList.size(); i++){


            card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBackground(Color.WHITE);

            cardText = new JTextPane();
            cardText.setEditable(false);
            cardText.setFont(new Font("Arial", Font.BOLD,12));
            cardText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            String dateTime = new SimpleDateFormat("M-d h:mm a").format((forecastList.get(i).getTime())*1000L);
            cardText.setText(forecastList.get(i).getWeekday() +"\n" + dateTime);
            card.add(cardText);

            ImageIcon imageIcon = new ImageIcon("src/weatherapp/resources/icon/" + forecastList.get(i).getIcon() + ".png");
            Image image = imageIcon.getImage();
            Image icon = getScaledImage(image, 24,24);
            ImageIcon sii = new ImageIcon(icon);
            JLabel scaledImageIcon = new JLabel(sii);
            card.add(scaledImageIcon);
            scaledImageIcon.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            cardText = new JTextPane();
            cardText.setEditable(false);
            StyledDocument doc = cardText.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0,doc.getLength(), center, false);

            Long temp = Math.round(forecastList.get(i).getTemp());
            Long tempMin = Math.round(forecastList.get(i).getTemp_min());
            Long tempMax = Math.round(forecastList.get(i).getTemp_max());
            Integer humidity = forecastList.get(i).getHumidity();
            Object pressure = Math.round(forecastList.get(i).getPressure());

            String forecast = temp.toString() + "\u00B0\n\n"+
                    "RH " + humidity + "\n" + pressure + "Pa";
            doc.insertString(0,forecast,null);

            card.add(cardText);

            cardHolder.add(card);
        }

        String currentDay = forecastList.get(0).getWeekday();
        String nextDay = null;

        int k = 0;

        for(int i = 0; i < 5; i++){
            int m = 0;
            double avgTemp = 0;
            double lowTemp = Double.MAX_VALUE;
            double highTemp = 0;
            for(int j = k; j < forecastList.size(); j++){
                if(!currentDay.equals(forecastList.get(j).getWeekday())){
                    nextDay = forecastList.get(j).getWeekday();

                    avgTemp = Math.round(avgTemp/m);
                    lowTemp = Math.round(lowTemp);
                    highTemp = Math.round(highTemp);
                    k++;
                    break;
                }
                if(forecastList.get(j).getTemp()<lowTemp)
                    lowTemp = forecastList.get(j).getTemp();
                if(forecastList.get(j).getTemp()>highTemp)
                    highTemp = forecastList.get(j).getTemp();
                avgTemp +=forecastList.get(j).getTemp();
                m++;
                k++;
            }

            System.out.println("avg: "+(int) avgTemp + ", low: " + lowTemp + ", high: " +highTemp);
            currentDay = nextDay;
        }
    }
}
