package com.example.thomas.resttemplateexample1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends Activity implements MyAsyncListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The connection URL
        String url = "http://www.yr.no/sted/Norge/Nordland/Rana/Mo/varsel.xml";

        RestAsyncTask restTask = new RestAsyncTask();
        restTask.delegate = this;

        restTask.execute(url);

    }

    @Override
    public void newDataEvent(String data) {
        Log.d("Data:", data);
    }
}
