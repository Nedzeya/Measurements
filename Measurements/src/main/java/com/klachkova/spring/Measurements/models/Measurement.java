package com.klachkova.spring.Measurements.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "The value must be higher than -100")
    @Max(value = 100, message = "The value must be less than 100")
    private Float value;

    @Column(name = "raining")
    @NotNull(message = "The field must not be empty")
    private Boolean raining;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "sensor_name", referencedColumnName = "name")
    private Sensor sensor;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
