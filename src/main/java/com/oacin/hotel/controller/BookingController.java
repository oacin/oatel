package com.oacin.hotel.controller;

import java.util.List;

import com.oacin.hotel.model.Booking;
import com.oacin.hotel.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
  @Autowired
  BookingRepository repository;

  @GetMapping("/booking")
  List<Booking> findAll()
  {
    return repository.findAll();
  }

  @GetMapping("/booking/{id}")
  Booking findById(@PathVariable int id)
  {
    return repository.findById(id);
  }
}
