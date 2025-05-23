package com.example.SesnorClient.rest;

import com.example.SesnorClient.entity.Measurements;
import com.example.SesnorClient.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MeasurementsCommunication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/measurements";

    public void addMeasurements(Measurements measurements) {
        if (measurements.getSensor() == null) {
            Sensor sensor = new Sensor();
            sensor.setName("Sensor1");  // set a valid sensor name
            measurements.setSensor(sensor);
        }
        restTemplate.postForObject(
                URL + "/add",
                measurements,
                Measurements.class);
    }

    public List<Measurements> getMeasurements() {
        ResponseEntity<List<Measurements>> measurements = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Measurements>>(){

                }
        );
        return measurements.getBody();
    }
}






