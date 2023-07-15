package com.sda.carrentalproject.exception;

public class WrongClientIdException extends RuntimeException{

  public WrongClientIdException() {
  }
  public WrongClientIdException(String message) {
    super(message);
  }
  public WrongClientIdException(String message, Throwable cause) {
    super(message, cause);
  }
  public WrongClientIdException(Throwable cause) {
    super(cause);
  }
  public WrongClientIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }



}
