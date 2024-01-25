package com.klachkova.spring.Measurements.util.converters;

import com.klachkova.spring.Measurements.dto.SensorDTO;
import com.klachkova.spring.Measurements.models.Sensor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensorConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public SensorConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Sensor toSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    public SensorDTO toSensorDTO(Sensor sensor) {

        return modelMapper.map(sensor, SensorDTO.class);
    }
}
