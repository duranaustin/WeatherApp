package weatherapp.gui;

import weatherapp.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.List;


public class WeatherUI extends JFrame {
    private WeatherEngine engine;


    private JPanel mainFrame;
    private JPanel mainFrame2;
    private JPanel mainPanel;
    private JScrollPane forecastScroller = new JScrollPane();
    private JPanel scrollerInset;
    private JPanel fiveDaySummaryHolder;
    private JPanel fiveDaySummary;
    private JPanel scrollPaneHolder;
    private JPanel dayCard;
    private JLabel fiveDayText;
    private JPanel card;
    private JPanel mainMenu;
    private JPanel mainSubPanel;
    private JPanel mainSubPanelCard;

    private JLabel mainMenuText;
    private JLabel cardText;

    private List<WeatherForecast> forecastList;
    private WeatherCurrent forecastCurrent;

    public WeatherUI() throws Exception {
        this.engine = new WeatherEngine();
        engine.setWeatherCurrent();
        forecastCurrent = engine.getCurrentWeather();

        engine.setWeatherForecast();
        forecastList = engine.getForecastList();

        /*
         * background attributed to:
         * <a href="https://www.freepik.com/free-photos-vectors/background">Background vector created by kjpargeter - www.freepik.com</a>
         */
        $$$setupUI$$$();
        mainFrame.updateUI();

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.updateUI();

        scrollPaneHolder.setOpaque(false);
        scrollPaneHolder.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        scrollPaneHolder.updateUI();

        forecastScroller.setOpaque(false);
        forecastScroller.setBackground(new Color(0, 0, 0, 0));
        /*forecastScroller.setBorder(null);
        scrollerInset.updateUI();*/

        fiveDaySummary.setOpaque(false);
        fiveDaySummary.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        fiveDaySummary.updateUI();
    }


    public void showMainFrame() throws Exception {
        JFrame frame = new JFrame("Weather App");


        frame.setContentPane(mainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        setLocationRelativeTo(null);
        engine = new WeatherEngine();
        frame.setVisible(true);
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainFrame.setBackground(new Color(-12509931));
        mainFrame.setMinimumSize(new Dimension(900, 500));
        mainFrame.setOpaque(false);
        mainFrame.setPreferredSize(new Dimension(900, 700));
        mainFrame.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainFrame;
    }


    private class TransparentPanel extends JPanel {
        {
            setOpaque(false);
            setBackground(new Color(0f, 0f, 0f, .0f));

        }

        public void paintComponent(Graphics g) {
            g.setColor(getBackground());
            Rectangle r = g.getClipBounds();
            g.fillRect(r.x, r.y, r.width, r.height);
            super.paintComponent(g);
        }
    }

    private class TransparentTextLabel extends JLabel {
        {
            setFocusable(false);
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, 13));

        }
    }

    private static class MyViewport extends JViewport {

        public MyViewport() {
            this.setOpaque(false);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(0, 0, 0, 0));
        }
    }

    private class MainFrame extends JPanel {
        ImageIcon bg = new ImageIcon("/src/weatherapp/resources/image/background.jpg");
        Image background = bg.getImage();
        public MainFrame() {
            this.setLayout(new GridLayout(3, 2));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
        }

    }
    public class ImagePanel extends JPanel {
        Image im;
        public ImagePanel(Image im) {
            this.im = im;
        }

        public void paintComponent(Graphics g) {
            g.drawImage(im,0,0, getWidth(), getHeight(), this);
            super.paintComponent(g);
        }
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
        // custom create components here
        mainFrame = new JPanel();
        mainFrame.setLayout(new BorderLayout());

        mainFrame2 = new MainFrame();
        mainFrame2.setLayout(new GridLayout(3, 2));
        mainFrame2.setMinimumSize(new Dimension(900, 500));
        mainFrame2.setPreferredSize(new Dimension(900, 700));
//        mainFrame2.setOpaque(true);
//        mainFrame2.setBackground(new Color(0f, 0f, 1f, 1f));


        mainPanel = new RoundedPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(.2f, .2f, .2f, .0f));
        mainPanel.setDoubleBuffered(true);
        mainPanel.setEnabled(true);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame2.add(mainPanel, gbc);

        scrollPaneHolder = new TransparentPanel();
        scrollPaneHolder.setLayout(new BorderLayout(0, 0));
        scrollPaneHolder.setBackground(new Color(0, 0, 0, 0));
        scrollPaneHolder.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame2.add(scrollPaneHolder, gbc);

        fiveDaySummary = new TransparentPanel();
        fiveDaySummary.setLayout(new BorderLayout(0, 0));
        fiveDaySummary.setBackground(new Color(0, 0, 0, 0));
        fiveDaySummary.setDoubleBuffered(true);
        fiveDaySummary.setEnabled(true);
        fiveDaySummary.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame2.add(fiveDaySummary, gbc);
        mainFrame.add(mainFrame2);

        /**
         * mainPanel->mainMenu->
         * mainSubPanel->mainMenuText, mainMenuText, mainMenuText
         * each Jpanel should be created in its own custom class
         * to tidy up the code (it looks like shit, sorry)
         * and instantiate in weatherUI meathod, not here
         */
        //setup
        mainMenu = new RoundedPanel();
        mainMenu.setLayout(new GridLayout(2, 0));
        mainMenu.setBackground(new Color(.2f, .2f, .2f, .7f));
        mainSubPanel = new TransparentPanel();
        mainSubPanel.setLayout(new GridLayout(0, 3));


        //new card (0,0)
        mainSubPanelCard = new TransparentPanel();
        mainSubPanelCard.setOpaque(false);
        mainSubPanelCard.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainSubPanelCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        String weekday = (forecastCurrent.getWeekday()).substring(0, Math.min(forecastCurrent.getWeekday().length(), 3));
        StringBuilder sb = new StringBuilder();
        sb.append("<html><span style='font-size:10px;font-weight:100'>" + weekday + ", " + forecastCurrent.getDate() + "</span><div style='font-size:14px; font-weight:400; margin-top:0'>" +
                forecastCurrent.getTime() + "</div>" + "<div style='font-size:14px;font-weight:400; margin-top:-5'>" + forecastCurrent.getCity() + "</div>" + "</html>");
        mainMenuText = new TransparentTextLabel();

        mainMenuText.setText(sb.toString());
        mainSubPanelCard.add(mainMenuText);
        mainSubPanel.add(mainSubPanelCard);

        //new card (0,1)
        mainSubPanelCard = new TransparentPanel();
        mainSubPanelCard.setOpaque(false);
        mainSubPanelCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainSubPanelCard.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainMenuText = new TransparentTextLabel();
        mainMenuText.setForeground(Color.WHITE);
        String currentTemp = String.valueOf(Math.round(forecastCurrent.getTemp()));
        mainMenuText.setText("<html><div style='font-size:48px; text-align:center; font-weight:100'>" + currentTemp + "</div></html>");
        mainSubPanelCard.add(mainMenuText);
        mainMenuText = new TransparentTextLabel();
        mainMenuText.setForeground(Color.WHITE);
        mainMenuText.setText("<html><span style='font-size:13px;'><sup>&deg;<sup>F</span><br><br></html>");
        mainSubPanelCard.add(mainMenuText);
        mainSubPanel.add(mainSubPanelCard);
        mainMenuText = new TransparentTextLabel();
        mainMenuText.setForeground(Color.WHITE);
        String temp_Min = String.valueOf(Math.round(forecastCurrent.getTemp_min()));
        String temp_Max = String.valueOf(Math.round(forecastCurrent.getTemp_max()));
        mainMenuText.setText("<html><div style='font-size:9px; text-align:left; font-weight:100'>&uarr;" + temp_Max + "<span style='font-size:9px;'>&deg;</span><br><br></div>" +
                "<div style='font-size:9px; text-align:left; font-weight:100'>&darr;" + temp_Min + "<span style='font-size:9px;'>&deg;</span><</div></html>");
        mainSubPanelCard.add(mainMenuText);
        mainSubPanel.add(mainSubPanelCard);

        //new card (0,2)
        mainSubPanelCard = new TransparentPanel();
        mainSubPanelCard.setOpaque(false);
        mainSubPanelCard.setBorder(BorderFactory.createEmptyBorder(-10, 10, 10, 10));
        mainSubPanelCard.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon imageIcon = new ImageIcon("src/weatherapp/resources/icon/" + forecastCurrent.getIcon() + ".png");
        mainMenuText = new TransparentTextLabel();
        mainMenuText.setIcon(imageIcon);
        mainMenuText.setHorizontalTextPosition(JLabel.CENTER);
        mainMenuText.setVerticalTextPosition(JLabel.BOTTOM);
        mainMenuText.setIconTextGap(-20);
        mainMenuText.setText("<html><span style='font-size:12px; font-weight:100'>" + forecastCurrent.getDescription() + "</span></html>");
        mainSubPanelCard.add(mainMenuText);
        mainSubPanel.add(mainSubPanelCard);

        mainMenu.add(mainSubPanel);
        //add next supPanel here
        mainPanel.add(mainMenu);


        /**
         * middle panel below
         * holds all forecasts
         */


        scrollerInset = new TransparentPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 5;
        c.ipady = 5;
        c.fill = GridBagConstraints.BOTH;
        gridBagLayout.setConstraints(scrollerInset, c);
        scrollerInset.setOpaque(false);
        scrollerInset.setBackground(new Color(.2f, .2f, .2f, .7f));
        for (int i = 0; i < forecastList.size(); i++) {
            card = new TransparentPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

            cardText = new TransparentTextLabel();
            cardText.setHorizontalAlignment(SwingConstants.CENTER);
            weekday = forecastList.get(i).getWeekday().substring(0, Math.min(forecastCurrent.getWeekday().length(), 3));
            String time = new SimpleDateFormat("hh:mm a").format((forecastList.get(i).getTime()) * 1000L);
            String temp = String.valueOf(Math.round(forecastList.get(i).getTemp()));

            cardText.setText("<html><div style='text-align: center; font-size:9px'>" + weekday + "<br>" + time +
                    "</div><br><br><br><div style='text-align: center; font-size:9px'>" + temp + "&deg;<div></html>");

            imageIcon = new ImageIcon("src/weatherapp/resources/icon/" + forecastList.get(i).getIcon() + ".png");
            Image image = imageIcon.getImage();
            Image icon = getScaledImage(image, 30, 30);
            imageIcon = new ImageIcon(icon);
            cardText.setIcon(imageIcon);
            cardText.setHorizontalTextPosition(JLabel.CENTER);
            card.add(cardText);
            scrollerInset.add(card);
        }

        JViewport viewport = new MyViewport();
        viewport.setView(scrollerInset);
        forecastScroller.setViewport(viewport);
//        this.add(scrollPane);


//        forecastScroller.setViewportView(scrollerInset);
        scrollPaneHolder.add(forecastScroller);
        forecastScroller.setWheelScrollingEnabled(true);
        forecastScroller.getHorizontalScrollBar().setUnitIncrement(32);
        forecastScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        forecastScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        forecastScroller.setBorder(new LineBorder(new Color(.2f, .2f, .2f, .7f), 30, true));
        /**
         * bottom panel below
         * holds 5 day summary
         */
        fiveDaySummaryHolder = new RoundedPanel();
//        fiveDaySummaryHolder.setOpaque(false);
        fiveDaySummaryHolder.setBackground(new Color(.2f, .2f, .2f, .7f));
        fiveDaySummaryHolder.setLayout(new GridLayout(0, 5, 5, 0));

        //my hacky way of summarizing each day
        String currentDay = forecastList.get(0).getWeekday();
        String nextDay = null;
        int k = 0;
        for (int i = 0; i < 5; i++) {
            int m = 0;
            double avgTemp = 0;
            double lowTemp = Double.MAX_VALUE;
            double highTemp = 0;
            for (int j = k; j < forecastList.size(); j++) {
                if (!currentDay.equals(forecastList.get(j).getWeekday())) {
                    nextDay = forecastList.get(j).getWeekday();

                    avgTemp = Math.round(avgTemp / m);
                    lowTemp = Math.round(lowTemp);
                    highTemp = Math.round(highTemp);
                    k++;
                    break;
                }
                if (forecastList.get(j).getTemp() < lowTemp)
                    lowTemp = forecastList.get(j).getTemp();
                if (forecastList.get(j).getTemp() > highTemp)
                    highTemp = forecastList.get(j).getTemp();
                avgTemp += forecastList.get(j).getTemp();
                m++;
                k++;
            }
            card = new TransparentPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            fiveDayText = new TransparentTextLabel();
            fiveDayText.setHorizontalAlignment(SwingConstants.CENTER);
            fiveDayText.setText("<html><div style='font-size:14px; text-align: center;'>" + currentDay + "</div><br>" +
                    "<div>add image here</div><br><div style='text-align: center;'>" +
                    "<span style='font-size: 12px;'>&uarr;" + highTemp + "&deg;</span>" +
                    "</div><div style='font-size: 8px;'>add vertical<br>spacer here</div></html>");
            card.add(fiveDayText);

            /*JPanel v = new TransparentPanel();
            int vHeight = (int)((double) (highTemp-lowTemp));
            v.setSize(1,(vHeight));
            v.setBackground(Color.BLACK);
            card.add(v);*/

            fiveDayText = new TransparentTextLabel();
            fiveDayText.setHorizontalAlignment(SwingConstants.CENTER);
            fiveDayText.setText("<html><div style='font-size:14px; text-align: center;'>" +
                    "<span style='font-size:12px;'>&darr;" + lowTemp + "&deg;</span>" +
                    "</div></html>");
            card.add(fiveDayText);
            fiveDaySummaryHolder.add(card);
            System.out.println("avg: " + (int) avgTemp + ", low: " + lowTemp + ", high: " + highTemp);
            currentDay = nextDay;
        }
        fiveDaySummary.add(fiveDaySummaryHolder);
    }
}
