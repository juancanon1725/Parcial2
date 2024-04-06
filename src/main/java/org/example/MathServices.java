package org.example;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static spark.Spark.*;

public class MathServices {

    public static void main(String[] args) {
        port(getPort());
        get("/linealSearch", (req, res) -> {
            String lineal = req.queryParams("list");
            List<Integer> linealList = alternateList(lineal);
            int val = Integer.parseInt(req.queryParams("value"));
            int spot = linealSearch(linealList, val);
            return jsonForm("Lineal Search", linealList, val, spot);
        });
        get("/binarySearch", (req, res) -> {
            String line = req.queryParams("list");
            List<Integer> lineList = alternateList(line);
            int val = Integer.parseInt(req.queryParams("value"));
            int spot = binarySearch(lineList, val);
            return jsonForm("Binary Search", lineList, val, spot);
        });
    }

    public static List<Integer> alternateList(String lineal) {
        List<Integer> linealList = new ArrayList<>();
        String[] values = lineal.split(",");
            for (String value : values) {
                linealList.add(Integer.parseInt(value.trim()));
        }
        return linealList;
    }

    public static int linealSearch(List<Integer> linealList, int val) {
        for (int i = 0; i < linealList.size(); i++) {
            if (linealList.get(i).equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(List<Integer> lineList, int val) {
        int start = 0;
        int end = lineList.size() - 1;

        Collections.sort(lineList);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (lineList.get(mid) == val) {
                return mid;
            } else if (lineList.get(mid) < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String jsonForm(String operation, List<Integer> list, int value, int output){
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("list", list);
        json.put("value", value);
        json.put("output", output);
        return json.toString();
    }
}

