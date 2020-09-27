package com.oacin.hotel.model;

public class Room {
  
  private int number;
  private String floor;
  private String type;
  private int capacity;


  public Room() {
  }

  public Room(int number, String floor, String type, int capacity) {
    this.number = number;
    this.floor = floor;
    this.type = type;
    this.capacity = capacity;
  }

  public int getNumber() {
    return this.number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getFloor() {
    return this.floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

}
