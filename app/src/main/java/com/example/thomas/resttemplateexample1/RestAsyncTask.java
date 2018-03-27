package com.example.thomas.resttemplateexample1;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by thomas on 20.03.18.
 */

public class RestAsyncTask extends AsyncTask<String, Integer, String> {

    MyAsyncListener delegate;

    @Override
    protected String doInBackground(String... urls) {

        String result = "";
        try {
            // Create a new RestTemplate instance
   /**         RestTemplate restTemplate = new RestTemplate();

            // Add the String message converter
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            // Make the HTTP GET request, marshaling the response to a String
            result = restTemplate.getForObject(urls[0], String.class, "Android"); **/

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
            ResponseEntity<WeatherData> responseEntity = restTemplate.exchange(urls[0],
                    HttpMethod.GET, null, WeatherData.class);
            WeatherData weatherData = responseEntity.getBody();

            result = weatherData.getLocation().getName();

        } catch (Exception e) {
            Log.d("Error", e.toString());
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        delegate.newDataEvent(s);
    }
}
