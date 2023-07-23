package com.sda.carrentalproject.controller;


import com.sda.carrentalproject.domain.Car;
import com.sda.carrentalproject.dto.CarDto;
import com.sda.carrentalproject.mapper.CarMapper;
import com.sda.carrentalproject.service.CarService;
import java.net.URI;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class CarController {

  private final CarService carService;
  private final CarMapper carMapper;


  public CarController(CarService carService, CarMapper carMapper) {
    this.carService = carService;
    this.carMapper = carMapper;
  }

  //   /cars?available=true?color=blue
  @GetMapping("/cars")
  List<CarDto> getCars(@RequestParam Map<String, String> queryParams,
      Pageable pageable) {
    log.info("getting cars");
    log.info("query params: [{}]", queryParams);
    log.info("paging params: [{}]", pageable);
    return carService.findCarsBasedOnQueryParameters(queryParams)
          .stream()
          .map(car -> carMapper.fromEntityToDto(car))
          .toList();
  }







  @PostMapping("/cars")
  ResponseEntity<CarDto> createNewCar(@RequestBody CarDto carToSave, UriComponentsBuilder ucb ) {
    log.info("trying to save new car: [{}]", carToSave);

    Car createdCar = carService.saveCar(carMapper.fromDtoToEntity(carToSave));

    URI path = ucb.path("/api/car/{id}")
        .buildAndExpand(Map.of("id", createdCar.getId()))
        .toUri();

    return ResponseEntity.created(path).body(carMapper.fromEntityToDto(createdCar));



  }





}
