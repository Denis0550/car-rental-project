package com.sda.carrentalproject.mapper;

import com.sda.carrentalproject.domain.Car;
import com.sda.carrentalproject.domain.PriceList;
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
        .pricePerDayInEuroCents(entity.getPriceList().getPricePerDayInEuroCents())
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
        .priceList(new PriceList(dto.pricePerDayInEuroCents()))
        .build();
  }
}
