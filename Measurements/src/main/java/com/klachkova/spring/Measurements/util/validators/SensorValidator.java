package com.klachkova.spring.Measurements.util.validators;


import com.klachkova.spring.Measurements.models.Sensor;
import com.klachkova.spring.Measurements.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if (sensorsService.findOne(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "","A sensor with that name already exists");
        }
    }

}
