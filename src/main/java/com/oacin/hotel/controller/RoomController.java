package com.oacin.hotel.controller;

import java.util.List;

import com.oacin.hotel.model.Room;
import com.oacin.hotel.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
  @Autowired
  RoomRepository repository;

  @GetMapping("/room")
  List<Room> findAll()
  {
    return repository.findAll();
  }

  @GetMapping("/room/{number}")
  Room findByNumber(@PathVariable int number)
  {
    return repository.findByNumber(number);
  }
}
