package com.nuwe.exceptions;

public class EmailExistsException extends RuntimeException {
  public EmailExistsException(String email) {
    super("email: " + email + " already exists");
  }
}
