package com.sda.carrentalproject.exception;

public class PeriodCalculationException extends RuntimeException {

  public PeriodCalculationException() {
  }

  public PeriodCalculationException(String message) {
    super(message);
  }

  public PeriodCalculationException(String message, Throwable cause) {
    super(message, cause);
  }

  public PeriodCalculationException(Throwable cause) {
    super(cause);
  }

  public PeriodCalculationException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
