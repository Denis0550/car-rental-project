package com.sda.carrentalproject.configuration.data;

import com.sda.carrentalproject.dto.BookingRecordDto;
import com.sda.carrentalproject.dto.CarBookingRequestDto;
import com.sda.carrentalproject.mapper.BookingRecordMapper;
import com.sda.carrentalproject.service.BookingRecordService;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class BookingRecordController {

  private final BookingRecordService bookingRecordService;
  private final BookingRecordMapper bookingRecordMapper;

  public BookingRecordController(BookingRecordService bookingRecordService,
      BookingRecordMapper bookingRecordMapper) {
    this.bookingRecordService = bookingRecordService;
    this.bookingRecordMapper = bookingRecordMapper;
  }

  @GetMapping("/booking-records")
  public List<BookingRecordDto> allBookingRecords() {
    log.info("getting all booking records");

    return bookingRecordService.findAllBookingRecords()
        .stream()
        .map(bookingRecord -> bookingRecordMapper.fromEntityToDto(bookingRecord))
        .toList();
  }

  @PostMapping("/booking-records")
  public BookingRecordDto bookCar(@RequestBody CarBookingRequestDto carBookingRequest) {



    return null;
  }

}
