package com.williamdavid.valloowallet.exceptions;

public class CardNotFoundException extends RuntimeException {
  public CardNotFoundException(String message) {
    super(message);
  }
}
