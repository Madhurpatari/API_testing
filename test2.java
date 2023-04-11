package org.Geekster;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test2 {
    public static void main(String[] args) throws Exception {
        URL getUrl = new URL("https://api.zippopotam.us/us/33162");
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseData = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine())!=null){
                responseData.append(readLine);
            }
            in.close();
            JSONObject masterData = new JSONObject(responseData.toString());
            System.out.println("post code : "+masterData.getString("post code"));
            System.out.println("country : "+masterData.getString("country"));
            System.out.println("country abbreviation : "+ masterData.getString("country abbreviation"));
             JSONArray places_arr =masterData.getJSONArray("places");
            for (int i = 0; i < places_arr.length(); i++) {
                JSONObject object = places_arr.getJSONObject(i);
                System.out.println("place name : " +object.getString("place name"));
                System.out.println("longitude : "+ object.getString("longitude"));
                System.out.println("state : "+object.getString("state"));
                System.out.println("state abbreviation : "+object.getString("state abbreviation"));
                System.out.println("latitude : "+object.getString("latitude"));
            }
        }


    }
}