package com.example.usuario.loginabm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FetchAPI extends AppCompatActivity {

    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, updatedField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_api);

        Intent intent = getIntent();
        String Ciudad = intent.getStringExtra("Ciudad");
        //TextView ciudad = (TextView) findViewById(R.id.textView2);
        //ciudad.setText(Ciudad);

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);


        weather.placeIdTask asyncTask =new weather.placeIdTask(new weather.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature,
                                      String weather_humidity, String weather_pressure, String weather_updatedOn) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
            }
        });
        //asyncTask.execute("28.613900", "77.209000"); //  asyncTask.execute("Latitude", "Longitude")
        asyncTask.execute(Ciudad); //  asyncTask.execute("Latitude", "Longitude")
    }
}
