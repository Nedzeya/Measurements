package com.klachkova.spring.Measurements.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "The value must be higher than -100")
    @Max(value = 100, message = "The value must be less than 100")
    private Number value;
    @NotNull(message = "The field must not be empty")
    private boolean raining;

    @NotNull(message = "The field must not be empty")
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
