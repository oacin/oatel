package com.oacin.hotel;

public class Return {
  public String status;
  public String errorMessage;
  public Object object;

  public Return(Object object) {
    this.status = "OK";
    this.object = object;
  }

  public Return(String error) {
    this.status = "Error";
    this.errorMessage = error;
  }
}
