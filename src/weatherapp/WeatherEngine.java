package weatherapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;



public class WeatherEngine {

    private final String USER_AGENT = "Mozilla/5.0";

    public void test (String s) throws IOException {

        try (FileWriter writer = new FileWriter("src\\weatherapp\\resources\\myfile.json")) {
            writer.write(s);
        }
    }

        public static void main(String[] args) throws Exception {

            WeatherEngine http = new WeatherEngine();

            System.out.println("Testing 1 - Send Http GET request");
            http.sendGet();

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



}


