package org.Geekster;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test3 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://api.nationalize.io/?name=nathaniel");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponseData = new StringBuilder();
            String readLine;

            while((readLine = in.readLine())!= null){
                jsonResponseData.append(readLine);
            }
            in.close();

            JSONObject getObject = new JSONObject(jsonResponseData.toString());
            JSONArray getArray = getObject.getJSONArray("country");
            for (int i = 0; i < getArray.length(); i++) {
                JSONObject object = getArray.getJSONObject(i);
                System.out.println("country_id : "+object.getString("country_id"));
                System.out.println("probability : "+object.getDouble("probability"));
            }
            System.out.println("name : "+getObject.getString("name"));
        }else{
            System.out.println("Invalid URL : "+responseCode );
        }


    }
}
