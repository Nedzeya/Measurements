package com.klachkova.spring.Measurements.repositories;

import com.klachkova.spring.Measurements.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SensorsRepository extends  JpaRepository <Sensor,Integer>  {
Optional<Sensor> findByName (String name);
}
