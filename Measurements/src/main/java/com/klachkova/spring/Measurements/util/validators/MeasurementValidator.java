package com.klachkova.spring.Measurements.util.validators;

import com.klachkova.spring.Measurements.models.Measurement;
import com.klachkova.spring.Measurements.models.Sensor;
import com.klachkova.spring.Measurements.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class MeasurementValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {

        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;
        Sensor sensor = measurement.getSensor();
        if (sensor == null) return;
        if (sensorsService.findOne(sensor.getName()).isEmpty()) {
            errors.rejectValue("sensor", "",
                    "No such sensor in data base");
        }
    }
}
