package com.sda.carrentalproject.configuration.data;

import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;


// TODO: move it to develop profile

@Component
@Slf4j
public class ClientDataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;

    public ClientDataInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       log.info("Providing some clients");

       Client client = Client.builder()
               .name("Denis")
               .surname("Soroka")
               .phone("111-111")
               .email("whaaat@gmail.com")
               .address("Estonia")
               .dateOfBirth(LocalDate.of(1987, Month.DECEMBER, 24))
               .build();

       clientRepository.save(client);
    }
}
