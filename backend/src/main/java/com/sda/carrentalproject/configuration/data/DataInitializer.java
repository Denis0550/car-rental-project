package com.sda.carrentalproject.configuration.data;

import com.sda.carrentalproject.domain.Car;
import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.domain.PriceList;
import com.sda.carrentalproject.domain.enumeration.Color;
import com.sda.carrentalproject.repository.CarRepository;
import com.sda.carrentalproject.repository.ClientRepository;
import java.time.YearMonth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;



@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CarRepository carRepository;


    public DataInitializer(ClientRepository clientRepository, CarRepository carRepository) {
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      createClients();
      creteCars();

    }

    private void creteCars() {
      log.info("Creating some cars");

      Car car1Available = Car.builder()
          .brand("Ford")
          .model("Focus")
          .productionYear(YearMonth.of(2000, Month.DECEMBER))
          .color(Color.BLUE)
          .available(true)
          .priceList(new PriceList(10_000))
          .build();

      Car car2Available = Car.builder()
          .brand("Ford")
          .model("Fiesta")
          .productionYear(YearMonth.of(2010, Month.DECEMBER))
          .color(Color.BLUE)
          .available(true)
          .priceList(new PriceList(5_000))
          .build();

      Car car3Unavailable = Car.builder()
          .brand("Mazda")
          .model("VI")
          .productionYear(YearMonth.of(2000, Month.DECEMBER))
          .color(Color.PINK)
          .available(false)
          .priceList(new PriceList(12_000))
          .build();

      carRepository.save(car1Available);
      carRepository.save(car2Available);
      carRepository.save(car3Unavailable);

    }

  private void createClients() {
    log.info("Creating some clients");

    Client client = Client.builder()
            .name("Den")
            .surname("Sor")
            .phone("111-111")
            .email("whaaat@gmail.com")
            .address("Estonia")
            .dateOfBirth(LocalDate.of(1987, Month.DECEMBER, 24))
            .build();

    clientRepository.save(client);
  }
}
