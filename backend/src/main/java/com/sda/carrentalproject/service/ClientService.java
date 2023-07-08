package com.sda.carrentalproject.service;

import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.dto.ClientDto;
import com.sda.carrentalproject.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAllClients() {
        log.info("getting all clients from repository");

        var result = clientRepository.findAll();

        log.info("found [{}] clients", result.size());
        log.debug("results: {}", result);

        return result;
    }

    public Client saveClient(Client clientEntity) {
        log.info("creating new client: [{}]", clientEntity);

        var result = clientRepository.save(clientEntity);
        log.info("saved client: [{}]", result);

        return result;
    }



}
