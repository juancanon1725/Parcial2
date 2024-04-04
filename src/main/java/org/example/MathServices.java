package org.example;

import static spark.Spark.*;

public class MathServices {

    public static void main(String... args) {
        port(getPort());
        get("linear", (req, res) -> linearSearch(req.queryParams("name")));
    }

    public static String linearSearch(String value){
        String result = "";
        int n = 5;
        int i = 0;
        String[] list = new String[n];
        while(i < n){
            if (value == list[n]){
                result = list[n];
                i = i +1;
            }else{
                result = list[n-1];
            }
        }
        return result;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
