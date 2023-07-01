package com.sda.carrentalproject.repository;

import com.sda.carrentalproject.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
