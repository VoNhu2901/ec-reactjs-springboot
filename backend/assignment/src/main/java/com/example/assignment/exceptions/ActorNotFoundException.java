package com.example.assignment.exceptions;

public class ActorNotFoundException extends RuntimeException {

  public ActorNotFoundException() {
    super();
  }

  public ActorNotFoundException(String message) {
    super(message);
  }

  public ActorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

}
