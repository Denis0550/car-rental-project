package com.sda.carrentalproject.mapper;

import com.sda.carrentalproject.domain.Car;
import com.sda.carrentalproject.dto.CarDto;
import org.springframework.stereotype.Component;


@Component
public class CarMapper implements Mapper<Car, CarDto> {

  @Override
  public CarDto fromEntityToDto(Car entity) {
    return CarDto.builder()
        .id(entity.getId())
        .brand(entity.getBrand())
        .model(entity.getModel())
        .productionYear(entity.getProductionYear())
        .color(entity.getColor())
        .available(entity.isAvailable())
        .priceList(entity.getPriceList())
        .build();
  }

  @Override
  public Car fromDtoToEntity(CarDto dto) {
    return Car.builder()
        .id(dto.id())
        .brand(dto.brand())
        .model(dto.model())
        .productionYear(dto.productionYear())
        .color(dto.color())
        .available(dto.available())
        .priceList(dto.priceList())
        .build();
  }
}
