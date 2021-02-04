package jsonHttp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpServerExample {
    public static void main(String[] args) {

        System.out.println("***************************************************************************");
        System.out.println("*** This program gets the weather conditions for any city/state/country ***");
        System.out.println("***                 then saves that info to a Json file                 ***");
        System.out.println("***************************************************************************");
        //Gets city name
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease enter a city/state/country to get the current conditions: ");
        String city = input.nextLine();
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try{
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=imperial" +
                    "&APPID=************* My Weather Map API ****************");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) responseContent.append(line);
            reader.close();

            Gson gson = new Gson();
            WeatherConditions weatherConditions = gson.fromJson(responseContent.toString(), WeatherConditions.class);
            System.out.println(weatherConditions.toString());

            FileWriter fw = new FileWriter("conditions.json");
            gson.toJson(weatherConditions, fw);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
