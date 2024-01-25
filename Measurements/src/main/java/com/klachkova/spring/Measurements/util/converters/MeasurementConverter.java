package com.klachkova.spring.Measurements.util.converters;

import com.klachkova.spring.Measurements.dto.MeasurementDTO;
import com.klachkova.spring.Measurements.models.Measurement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeasurementConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        }

    public Measurement toMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    public MeasurementDTO toMeasurementDTO(Measurement measurement) {
        System.out.println("converting measurement to measurementDTO");
        return  modelMapper.map(measurement, MeasurementDTO.class);
    }

}
