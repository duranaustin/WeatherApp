package weatherapp.gui;

import weatherapp.WeatherEngine;

import javax.swing.*;

public class WeatherUI extends JFrame {
    private WeatherEngine engine;

    private JPanel mainFrame;
    private JButton btnOne;
    private JPanel mainPanel;
    private JLabel lblHello;

    public WeatherUI() throws Exception {
        this.engine = new WeatherEngine();
        mainPanel.updateUI();
        createBtnOne();
    }

    public void showMainFrame() throws Exception {
        JFrame frame = new JFrame("Weather App");
        frame.setContentPane(new WeatherUI().mainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createBtnOne() {
        btnOne.addActionListener(actionEvent -> lblHello.setVisible(true));
    }
}
