package com.klachkova.spring.SensorImitation.models;

import java.util.List;

public class MeasurementResponse {
    private List<MeasurementDTO> measurements;

    public MeasurementResponse() {
    }

    public MeasurementResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
