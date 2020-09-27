package com.oacin.hotel.controller;

import com.oacin.hotel.Return;
import com.oacin.hotel.model.Booking;
import com.oacin.hotel.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
  @Autowired
  BookingRepository repository;

  @GetMapping("/booking")
  public Return findAll()
  {
    try {
      return new Return(repository.findAll());
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @GetMapping("/booking/{id}")
  public Return findById(@PathVariable int id)
  {
    try {
      return new Return(repository.findById(id));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @PostMapping("/booking")
  public Return add(@RequestBody Booking booking)
  {
    try {
      return new Return(repository.add(booking));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @DeleteMapping("/booking/{id}")
  public Return destroy(@PathVariable int id)
  {
    try {
      return new Return(repository.destroy(id));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }
}
