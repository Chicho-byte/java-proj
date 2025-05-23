package com.example.SesnorClient.rest;

import com.example.SesnorClient.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SensorCommunication {

    @Autowired
    private RestTemplate restTemplate;

    String URL = "http://localhost:8080/sensors";

    public Sensor addSensor(Sensor sensor) {


        return  restTemplate.postForObject(
                URL +"/registration",
                sensor,
                Sensor.class
        );
    }
}
