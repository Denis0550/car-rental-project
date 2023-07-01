package com.sda.carrentalproject.mapper;


import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.dto.ClientDto;

public interface Mapper<E, D> {

    D fromEntityToDto(E entity);

    E fromDtoToEntity(D dto);



}
