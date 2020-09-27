package com.oacin.hotel.controller;

import com.oacin.hotel.Return;
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
  public Return findAll()
  {
    try {
      return new Return(repository.findAll());
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @GetMapping("/room/{number}")
  public Return findByNumber(@PathVariable int number)
  {
    try {
      return new Return(repository.findByNumber(number));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @PostMapping("/room")
  public Return add(@RequestBody Room room)
  {
    try {
      return new Return(repository.add(room));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @PutMapping("/room/{number}")
  public Return edit(@RequestBody Room room, @PathVariable int number)
  {
    try {
      return new Return(repository.edit(room, number));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }

  @PutMapping("room/toggleLock/{number}")
  public Return toggleLock(@PathVariable int number)
  {
    try {
      return new Return(repository.toggleLock(number));
    } catch (Exception e) {
      return new Return(e.getMessage());
    }
  }
}
