package com.sda.carrentalproject.service;


import com.sda.carrentalproject.domain.Car;
import com.sda.carrentalproject.exception.WrongCarIdException;
import com.sda.carrentalproject.repository.CarRepository;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarService {

  private static final String availableKey = "available";
  private static final String colorKey = "color";
  private static final String brandKey = "brand";
  private static final String modelKey = "model";





  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<Car> findAllCars() {
    log.info("getting all cars from repository");

    var result = carRepository.findAll();

    log.info("found [{}] cars", result.size());
    log.debug("results: {}", result);

    return result;

  }

  public Car saveCar(Car carEntity) {
    log.info("creating new car: [{}]", carEntity);

    var result = carRepository.save(carEntity);
    log.info("saved car: [{}]", result);

    return result;

  }

  public Car findCarWithId(long id) {
    log.info("trying to find car with id: [{}]", id);

    return carRepository.findById(id)
        .map(car -> {
          log.info("Found car [{}]", car);
          return car;
        })
        .orElseThrow(() -> new WrongCarIdException("No car with given id: [%s]".formatted(id)));

  }


  public Car findAvailableCarWithId(long id) {
    log.info("trying to find available car with given id: [{}]", id);
    return carRepository.findByIdAndAvailableTrue(id)
        .map(car -> {
          log.info("Found available car: [{}]", car);
          return car;
        })
        .orElseThrow(() -> new WrongCarIdException("Car with given id: [%s] is unavailable!".formatted(id)));
  }

  public List<Car> findRentCars() {
    log.info("trying to find rent cars");
    var rentCars = carRepository.findAllByAndAvailable(false);
    log.info("number of rent cars: [{}]", rentCars.size());
    log.debug("rent cars: {}", rentCars);
  }

  public List<Car> findAllCarsAvailableForBooking() {
    log.info("trying to find all cars available");
    var availableCars = carRepository.findAllByAndAvailable(true);
    log.info("number of available cars: [{}]", availableCars.size());
    log.debug("available cars: {}", availableCars);
    return availableCars;
  }


  public List<Car> findCarsBasedOnQueryParameters(Map<String, String> queryParams) {
    log.info("finding cars based on query parameters: {}", queryParams);

    List<Car> result;
    if (!queryParams.containsKey(availableKey)) {
      result = findAllCars();
    } else {
      boolean available = Boolean.parseBoolean(queryParams.get(availableKey));
      if (available) {
        result = findAllCarsAvailableForBooking();
      } else {
        result = findRentCars();
      }
    }
    return result;
  }


}
