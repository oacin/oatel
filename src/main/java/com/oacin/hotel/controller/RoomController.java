package com.oacin.hotel.controller;

import java.util.List;

import com.oacin.hotel.model.Room;
import com.oacin.hotel.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/room")
  void add(@RequestBody Room room)
  {
    repository.add(room);
  }

  @PutMapping("/room/{number}")
  void edit(@RequestBody Room room, @PathVariable int number)
  {
    repository.edit(room, number);
  }

  @PutMapping("room/toggleLock/{number}")
  void toggleLock(@PathVariable int number)
  {
    repository.toggleLock(number);
  }
}
