package com.sda.carrentalproject;

import com.sda.carrentalproject.repository.ClientRepository;
import com.sda.carrentalproject.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarRentalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalProjectApplication.class, args);
    }

    @Bean
    public ClientService clientService(ClientRepository repository) {
        return new ClientService(repository);
    }

}
