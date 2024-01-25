package com.klachkova.spring.Measurements.services;

import com.klachkova.spring.Measurements.models.Sensor;
import com.klachkova.spring.Measurements.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorsService {
    private final SensorsRepository sensorRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Sensor findOne (int id){
        return sensorRepository.findById(id).get();

    }
    public Optional<Sensor> findOne (String name){
         return  sensorRepository.findByName(name);
    }

    @Transactional
    public void save (Sensor sensor){
      sensorRepository.save(sensor);
    }


}
