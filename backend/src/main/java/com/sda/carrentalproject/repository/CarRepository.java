package com.sda.carrentalproject.repository;

import com.sda.carrentalproject.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
