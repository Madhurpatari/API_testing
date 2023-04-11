package org.Geekster;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test1 {
    public static void main(String[] args) throws Exception{
        URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if(responseCode==200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponseData = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine())!=null){
                jsonResponseData.append(readLine);
            }
            in.close();
            JSONObject masterData = new JSONObject(jsonResponseData.toString());
            System.out.println("categories : "+masterData.getJSONArray("categories"));
            System.out.println("icon_url : "+masterData.getString("icon_url"));
            System.out.println("id : "+masterData.getString("id"));
            System.out.println("updated_at : "+masterData.getString("updated_at"));
            System.out.println("url : "+masterData.getString("url"));
            System.out.println("value : "+masterData.getString("value"));
        }else {
            System.out.println("Invalid URL : " + responseCode);
        }
    }
}
