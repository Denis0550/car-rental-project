package com.sda.carrentalproject.repository;

import com.sda.carrentalproject.domain.Car;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

  Optional<Car> findByIdAndAvailableTrue(Long aLong);

}
