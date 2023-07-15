package com.sda.carrentalproject.repository;

import com.sda.carrentalproject.domain.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepository extends JpaRepository<BookingRecord,Long> {

}
