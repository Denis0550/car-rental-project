package com.sda.carrentalproject.repository;

import com.sda.carrentalproject.domain.BookingRecord;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRecordRepository extends JpaRepository<BookingRecord,Long> {


  @Query("""
    select br from BookingRecord br
    where br.client.name = :name and br.bookedCar.color = :color
""")
  Optional<BookingRecord> findByClientNameAndBookedCarColor(@Param("name") String name,
      @Param("color") String color);

}
