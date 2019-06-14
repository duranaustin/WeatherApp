package weatherapp;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * WeatherAPI sends a get request to our created API which notes our IP address and sends us back the respective Weather Info for our IP address location
 *
 * EXAMPLE: https://api.weather.gov
 * *** SLC *** https://api.weather.gov/points/39.4192,-111.9507
 * *** SLC Forecast *** https://api.weather.gov/gridpoints/SLC/90,114/forecast
 * EXAMPLE: our api
 *  api.openweathermap.org/data/2.5/forecast?id=$5781770&appid=3047a788b7d827644b13600e4d46ab7b
 * *** website : ec2-18-222-251-236.us-east-2.compute.amazonaws.com
 * *** website/json : http://ec2-18-222-251-236.us-east-2.compute.amazonaws.com/currentweather.json
 */
public class WeatherAPI {

    private final String USER_AGENT = "Mozilla/5.0";

    /**
     * Upon object creation WeatherAPI immediately uses sendGet() to send a get request to our created API
     * @throws Exception
     */
    public WeatherAPI() throws Exception {
        sendGet();
    }

    private void setGetRequest(String location) {

    }


    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "https://api.weather.gov/points/40.712,-111.8389";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        test(response.toString());

        //print result
        System.out.println(response.toString());

    }

    public void test (String s) throws IOException {

        try (FileWriter writer = new FileWriter("src\\weatherapp\\resources\\myfile.json")) {
            writer.write(s);
        }
    }

}
