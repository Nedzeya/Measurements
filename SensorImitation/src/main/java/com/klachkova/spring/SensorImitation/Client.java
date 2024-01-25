package com.klachkova.spring.SensorImitation;

import com.klachkova.spring.SensorImitation.actions.get.AllMeasurements;
import com.klachkova.spring.SensorImitation.actions.post.SensorRegistration;
import com.klachkova.spring.SensorImitation.actions.get.Temperature;
import com.klachkova.spring.SensorImitation.actions.post.MeasurementsSending;
import com.klachkova.spring.SensorImitation.util.ChartMaker;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public class Client {

    public static void main(String[] args) throws JsonProcessingException {

        final String urlServer = "http://localhost:8081";

        final String urlSensorReg = urlServer + "/sensors/registration";

        final String urlGetMeasurements = urlServer + "/measurements";

        final String urlMeasurementsAdd = urlServer + "/measurements/add";

        final String urlGetTemperatures = urlServer + "/measurements/temperature";


        //регистрация нового сенсора
        SensorRegistration sensorRegistration = new SensorRegistration();
        sensorRegistration.register(urlSensorReg);

        // отправка 1000 измерений с этого сенсора в БД
        new MeasurementsSending( sensorRegistration).send10TimesRandom(urlMeasurementsAdd);

        //получаем все измерения в виде их количества
        System.out.println(new AllMeasurements().count(urlGetMeasurements));

        //строим график температур

        Map temperature = new Temperature().getTemperature(urlGetTemperatures);
        ChartMaker chartMaker = new ChartMaker(temperature, "Temperature");
        chartMaker.showChart();


    }


}
