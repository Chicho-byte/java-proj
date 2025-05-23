package com.example.SesnorClient;


import com.example.SesnorClient.entity.Measurements;
import com.example.SesnorClient.entity.Sensor;
import com.example.SesnorClient.rest.MeasurementsCommunication;
import com.example.SesnorClient.rest.SensorCommunication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SensorClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SensorClientApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        ApplicationContext context = app.run(args);

        MeasurementsCommunication measurementsCommunication = context.getBean(MeasurementsCommunication.class);
        SensorCommunication sensorCommunication = context.getBean(SensorCommunication.class);

//		Sensor sensor = sensorCommunication.addSensor(new Sensor("JP-M-922"));
        Sensor sensor1 = new Sensor("JP-M-922");
        Sensor sensor2 = new Sensor("HP-110");
        Sensor sensor3 = new Sensor("HP-8630");
        Measurements measurements = new Measurements(14, true, sensor1);


        for (int i = 1; i < 1000; i++) {
            measurements.setValue((measurements.getValue() + i)/100);
            measurements.setRaining(i % 2 == 0);
            if (i <= 400) {
                measurements.setSensor(sensor1);
            } else if (i <= 800) {
				measurements.setSensor(sensor2);
            }else {
				measurements.setSensor(sensor3);
			}

			measurementsCommunication.addMeasurements(measurements);
        }


        List<Measurements> measurementsList = measurementsCommunication.getMeasurements();
        System.out.println("Get Measurements: " + "\n" + measurementsList);
    }

    @Override
    public void run(String... args) {
        // Your client logic here
    }
}
