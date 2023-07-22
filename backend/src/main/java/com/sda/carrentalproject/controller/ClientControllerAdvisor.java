package com.sda.carrentalproject.controller;

import com.sda.carrentalproject.dto.ErrorResponse;
import com.sda.carrentalproject.exception.WrongClientIdException;
import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestControllerAdvice
@Slf4j
public class ClientControllerAdvisor {
  @ExceptionHandler(WrongClientIdException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)

  public ErrorResponse handleWrongClientIdException(WrongClientIdException exception) {

    String currentRequestPath = requestCurrentPath();

    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value())
        .error("Car not found")
        .message(exception.getMessage())
        .path(currentRequestPath)
        .build();
  }

  private static String requestCurrentPath() {
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .build()
        .getPath();
  }

  @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleClientValidationIssues(Exception exc) {
    String errorMessage = "";
    if (exc instanceof ConstraintViolationException validationExc) {
      log.info("handleClientValidationIssues: getMessage() :[{}]", validationExc.getMessage());
      log.warn("ConstraintViolationException", validationExc);
      errorMessage = validationExc.getConstraintViolations().toString();
    } else if (exc instanceof MethodArgumentNotValidException methodExc) {
      log.info("handleClientValidationIssues: getMessage(): [{}]", methodExc.getMessage());
      log.warn("MethodArgumentNotValidException", methodExc);
      errorMessage = methodExc.getMessage();
    }
    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .error("Validation error")
        .path(requestCurrentPath())
        .message(errorMessage)
        .build();
  }

}
