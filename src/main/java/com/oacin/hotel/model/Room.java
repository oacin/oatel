package com.oacin.hotel.model;

public class Room {
  
  private int number;
  private String floor;
  private String category;
  private int capacity;


  public Room() {
  }

  public Room(int number, String floor, String category, int capacity) {
    this.number = number;
    this.floor = floor;
    this.category = category;
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

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

}
