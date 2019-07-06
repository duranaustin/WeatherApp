package weatherapp.gui;

import weatherapp.WeatherEngine;

import javax.swing.*;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WeatherUI extends Application 
{
    private WeatherEngine engine;
    
    @FXML
    private Label lbForecast;
    
    @FXML
    private Label lbCurrentDay;
    
    @FXML
    private Label lbTemp;
    
    @FXML
    private Label lbCity;
    
    @FXML
    private Label lbStatus;
    
    @FXML
    private Label lbStatusMon;
    
    @FXML
    private Label lbStatusTue;
    
    @FXML
    private Label lbStatusWed;
    
    @FXML
    private Label lbStatusThu;
    
    @FXML
    private Label lbStatusFri;
    
    @FXML
    private Label lbStatus12am;
    
    @FXML
    private Label lbStatus3am;
    
    @FXML
    private Label lbStatus6am;
    
    @FXML
    private Label lbStatus9am;
    
    @FXML
    private Label lbStatus12pm;
    
    @FXML
    private Label lbStatus3pm;
    
    @FXML
    private Label lbStatus6pm;
    
    @FXML
    private Label lbStatus9pm;
    
    @FXML
    private Label lbHiLo;
    
    @FXML
    private Label lbHiLoMon;
    
    @FXML
    private Label lbHiLoTue;
    
    @FXML
    private Label lbHiLoWed;
    
    @FXML
    private Label lbHiLoThu;
    
    @FXML
    private Label lbHiLoFri;
    
    @FXML
    private Label lbHiLo12am;
    
    @FXML
    private Label lbHiLo3am;
    
    @FXML
    private Label lbHiLo6am;
    
    @FXML
    private Label lbHiLo9am;
    
    @FXML
    private Label lbHiLo12pm;
    
    @FXML
    private Label lbHiLo3pm;
    
    @FXML
    private Label lbHiLo6pm;
    
    @FXML
    private Label lbHiLo9pm;
    
    @FXML
    private ImageView imgStatus;
    
    @FXML
    private ImageView imgStatus12am;
    
    @FXML
    private ImageView imgStatus3am;
    
    @FXML
    private ImageView imgStatus6am;
    
    @FXML
    private ImageView imgStatus9am;
    
    @FXML
    private ImageView imgStatus12pm;
    
    @FXML
    private ImageView imgStatus3pm;
    
    @FXML
    private ImageView imgStatus6pm;
    
    @FXML
    private ImageView imgStatus9pm;
    
    @FXML
    private ImageView imgStatusMon;
    
    @FXML
    private ImageView imgStatusTue;
    
    @FXML
    private ImageView imgStatusWed;
    
    @FXML
    private ImageView imgStatusThu;
    
    @FXML
    private ImageView imgStatusFri;
    
    @FXML
    private Button btnSearch;
    
    @FXML
    private TextField txtSearchCity;

    public WeatherUI() throws Exception 
    {
        this.engine = new WeatherEngine();
//        mainPanel.updateUI();
//        createBtnOne();
    }
/*
*    public void showMainFrame() throws Exception {
*        JFrame frame = new JFrame("Weather App");
*        frame.setContentPane(new WeatherUI().mainFrame);
*        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*        frame.pack();
*        setLocationRelativeTo(null);
*        frame.setVisible(true);
*    }
*
*    private void createBtnOne() {
*        btnOne.addActionListener(actionEvent -> lblHello.setVisible(true));
*    }
* 
*/  

	@Override
	public void start(Stage primaryStage) throws Exception {
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("WeatherGUI.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Weather App");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Cannot load Primary Window! Exiting Program..."
					, e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	@FXML
	void searchCity()
	{
		// TODO write code that searches for the city here.
	}
	
	public void init()
	{
		// TODO write code that sets the labels and/or graphics equal to the WeatherApp fields.
	}
}
