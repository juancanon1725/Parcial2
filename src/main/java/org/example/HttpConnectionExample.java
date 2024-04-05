package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "";

    public static String getRequest(String requestUrl) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }
            } else {
                System.out.println("GET request not worked, response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error sending GET request: " + e.getMessage());
        }
        System.out.println("GET DONE");
        return response.toString();
    }

    public static void setURL(String requestUrl) {
        GET_URL = requestUrl;
    }


    public static String getResponse(){
        return getRequest(GET_URL);
    }

} 