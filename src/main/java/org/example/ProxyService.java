package org.example;

import static spark.Spark.*;
public class ProxyService {

    private static final String[] SERVERS = { "http://23.20.193.166:4567/", "http://54.234.199.171:4567/" };
    private static final int SERVER_COUNT = SERVERS.length;
    private static int serverIndex = 0;

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");

        get("linealSearch", (req, res) -> {
            try {
                String serverUrl = getNextServerUrl();
                String url = serverUrl + "linealSearch?list=" + req.queryParams("list") + "&value=" + req.queryParams("value");
                HttpConnectionExample.setURL(url);
                return HttpConnectionExample.getResponse();
            } catch (Exception e) {
                return "Error en la búsqueda lineal: " + e.getMessage();
            }
        });

        get("binarySearch", (req, res) -> {
            try {
                String serverUrl = getNextServerUrl();
                String url = serverUrl + "binarySearch?list=" + req.queryParams("list") + "&value=" + req.queryParams("value");
                HttpConnectionExample.setURL(url);
                return HttpConnectionExample.getResponse();
            } catch (Exception e) {
                return "Error en la búsqueda binaria: " + e.getMessage();
            }
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

    private static synchronized String getNextServerUrl() {
        String serverUrl = SERVERS[serverIndex];
        incrementServerIndex();
        return serverUrl;
    }

    static synchronized void incrementServerIndex() {
        serverIndex = (serverIndex + 1) % SERVER_COUNT;
    }
}

