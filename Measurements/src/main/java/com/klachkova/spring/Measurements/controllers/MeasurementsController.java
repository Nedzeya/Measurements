package com.klachkova.spring.Measurements.controllers;

import com.klachkova.spring.Measurements.dto.MeasurementDTO;
import com.klachkova.spring.Measurements.dto.MeasurementResponse;
import com.klachkova.spring.Measurements.models.Measurement;
import com.klachkova.spring.Measurements.services.MeasurementsService;
import com.klachkova.spring.Measurements.util.converters.MeasurementConverter;
import com.klachkova.spring.Measurements.util.validators.MeasurementValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import static com.klachkova.spring.Measurements.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
    private final MeasurementValidator measurementValidator;
    private final MeasurementConverter measurementConverter;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService,
                                  MeasurementConverter measurementConverter,
                                  MeasurementValidator measurementValidator) {
        this.measurementsService = measurementsService;
        this.measurementConverter = measurementConverter;
        this.measurementValidator = measurementValidator;
    }

    @GetMapping()
    public MeasurementResponse getMeasurements() {
        return new MeasurementResponse(measurementsService.findAll()
                .stream()
                .map(measurementConverter::toMeasurementDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public MeasurementDTO getMeasurement(@PathVariable("id") int id) {

        return measurementConverter.toMeasurementDTO(measurementsService.findOne(id));
    }

    @GetMapping("/rainyDaysCount")
    public int getRainyDaysCount() {
        return measurementsService.getRainyDaysCount();
    }

    @GetMapping("/temperature")
    public Map<LocalDateTime, Float> getTemperatures() {
        return measurementsService.getTemperatures();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MeasurementDTO measurementDTO,
                                             BindingResult bindingResult) {


        Measurement measurement = measurementConverter.toMeasurement(measurementDTO);

        measurementValidator.validate(measurement, bindingResult);

        if (bindingResult.hasErrors()) {
            returnErrorsToClient(bindingResult);
        }

        measurementsService.save(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
