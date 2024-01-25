package com.klachkova.spring.SensorImitation.models;

public class MeasurementDTO {

    private Number value;

    private boolean raining;

    private SensorDTO sensor;

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
