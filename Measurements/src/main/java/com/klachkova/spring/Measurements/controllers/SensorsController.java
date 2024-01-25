package com.klachkova.spring.Measurements.controllers;

import com.klachkova.spring.Measurements.dto.SensorDTO;
import com.klachkova.spring.Measurements.models.Sensor;
import com.klachkova.spring.Measurements.services.SensorsService;
import com.klachkova.spring.Measurements.util.converters.SensorConverter;
import com.klachkova.spring.Measurements.util.validators.SensorValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.klachkova.spring.Measurements.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorsService;
    private final SensorValidator sensorValidator;
    private final SensorConverter sensorConverter;

    @Autowired
    public SensorsController(SensorsService sensorsService, SensorValidator sensorValidator, SensorConverter sensorConverter) {
        this.sensorsService = sensorsService;
        this.sensorValidator = sensorValidator;
        this.sensorConverter = sensorConverter;
    }

    @GetMapping()
    public List<SensorDTO> getSensor() {
        return sensorsService.findAll()
                .stream()
                .map(sensorConverter::toSensorDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SensorDTO getSensor(@PathVariable("id") int id) {
        //status 200 - everything is ok
        return sensorConverter.toSensorDTO(sensorsService.findOne(id));
    }

    @GetMapping("/{name}")
    public SensorDTO getSensor(@PathVariable("name") String name) {
        //status 200 - everything is ok
        return sensorConverter.toSensorDTO(sensorsService.findOne(name).orElse(null));
    }

       @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid SensorDTO sensorDTO,
                                             BindingResult bindingResult) {

        System.out.println("method Post create started");
        Sensor sensor = sensorConverter.toSensor(sensorDTO);

        sensorValidator.validate(sensor, bindingResult);

        if (bindingResult.hasErrors()) {
            returnErrorsToClient(bindingResult);
        }
        sensorsService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}


