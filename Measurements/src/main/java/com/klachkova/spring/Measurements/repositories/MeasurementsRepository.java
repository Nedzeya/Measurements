package com.klachkova.spring.Measurements.repositories;

import com.klachkova.spring.Measurements.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository <Measurement, Integer> {
   List<Measurement> findByRaining (Boolean b);

}
