package com.sda.carrentalproject.exception;
public class WrongCarIdException extends RuntimeException {
  public WrongCarIdException() {
  }
  public WrongCarIdException(String message) {
    super(message);
  }
  public WrongCarIdException(String message, Throwable cause) {
    super(message, cause);
  }
  public WrongCarIdException(Throwable cause) {
    super(cause);
  }
  public WrongCarIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
