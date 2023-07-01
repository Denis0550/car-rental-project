package com.sda.carrentalproject.mapper;

import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<Client, ClientDto>{
    @Override
    public ClientDto fromEntityToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .hasDrivingLicense(entity.isHasDrivingLicense())
                .registrationDateTime(entity.getRegistrationDateTime())
                .dateOfBirth(entity.getDateOfBirth())
                .build();
    }

    @Override
    public Client fromDtoToEntity(ClientDto dto) {
        return Client.builder()
                .id(dto.id())
                .name(dto.name())
                .surname(dto.surname())
                .phone(dto.phone())
                .email(dto.email())
                .address(dto.address())
                .hasDrivingLicense(dto.hasDrivingLicense())
                .registrationDateTime(dto.registrationDateTime())
                .dateOfBirth(dto.dateOfBirth())
                .build();
    }
}
