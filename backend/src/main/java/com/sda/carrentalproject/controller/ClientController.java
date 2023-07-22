package com.sda.carrentalproject.controller;


import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.dto.ClientDto;
import com.sda.carrentalproject.mapper.ClientMapper;
import com.sda.carrentalproject.service.ClientService;
import java.net.URI;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("/api")
// #bean-name.property - use property value on given bean
//@CrossOrigin("#{clientController.allowedOrigin}")
// works from Spring 6.0
@CrossOrigin("${frontend.trusted-url}")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final String allowedOrigin;

    public ClientController(ClientService clientService,
                            ClientMapper clientMapper,
                            @Value("${frontend.trusted-url}") String allowedOrigin) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
        this.allowedOrigin = allowedOrigin;

        log.info("Allowed origin: [{}]", allowedOrigin);
    }

    public String getAllowedOrigin() {
        return allowedOrigin;
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


    @PostMapping("/clients")
    ResponseEntity<ClientDto> createNewClient(@RequestBody ClientDto clientToSave, UriComponentsBuilder ucb) {
        log.info("trying to save new client: [{}]", clientToSave);

        Client createdClient = clientService.saveClient(clientMapper.fromDtoToEntity(clientToSave));

        URI path = ucb.path("/api/client/{id}")
                .buildAndExpand(Map.of("id", createdClient.getId()))
                .toUri();

        return ResponseEntity.created(path)
                .body(clientMapper.fromEntityToDto(createdClient));
    }


}
