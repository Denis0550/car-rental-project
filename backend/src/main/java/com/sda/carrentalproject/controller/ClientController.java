package com.sda.carrentalproject.controller;


import com.sda.carrentalproject.dto.ClientDto;
import com.sda.carrentalproject.mapper.ClientMapper;
import com.sda.carrentalproject.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    private final ClientMapper clientMapper;


    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/clients")
    List<ClientDto> allClients() {
        log.info("all clients endpoint");

        var clients = clientService.getAllClients();

        return clients.stream()
                .map(client -> clientMapper.fromEntityToDto(client))
//                .map(clientMapper::fromEntityToDto)
                .toList();

    }




}
