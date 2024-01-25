package com.klachkova.spring.Measurements.services;

import com.klachkova.spring.Measurements.models.Measurement;
import com.klachkova.spring.Measurements.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository,
                               SensorsService sensorsService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsService = sensorsService;
    }
    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }
    public Measurement findOne(int id) {
        return  measurementsRepository.findById(id).get();
    }
    public int getRainyDaysCount() {
        return measurementsRepository.findByRaining(true).size();
    }

    public Map<LocalDateTime, Float> getTemperatures() {
        Map<LocalDateTime, Float> temperatures = new HashMap<>();

        for (Measurement m : findAll()) {
            temperatures.put(m.getCreatedAt(), m.getValue());
        }
        return temperatures;
    }

    @Transactional
    public void save(Measurement measurement) {
        updateMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    private void updateMeasurement(Measurement measurement) {
//current_time
        measurement.setCreatedAt(LocalDateTime.now());
//real sensor
        String sensorName = measurement.getSensor().getName();
        measurement.setSensor(sensorsService.findOne(sensorName).get());
    }
}
