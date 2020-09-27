package com.oacin.hotel.model;

import java.sql.Date;

public class Booking {

  private int id;
  private int room;
  private Date startDate;
  private Date endDate;
  private float price;
  private String guest;


  public Booking() {
  }

  public Booking(int id, int room, Date startDate, Date endDate, float price, String guest) {
    this.id = id;
    this.room = room;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
    this.guest = guest;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRoom() {
    return this.room;
  }

  public void setRoom(int room) {
    this.room = room;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public float getPrice() {
    return this.price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getGuest() {
    return this.guest;
  }

  public void setGuest(String guest) {
    this.guest = guest;
  }

}
