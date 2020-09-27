package com.oacin.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import com.oacin.hotel.model.Room;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {
  private final JdbcTemplate jdbcTemplate;

  public RoomRepository(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Room> findAll()
  {
    List<Room> rooms = new ArrayList<>();

    return rooms;
  }

  public Room findByNumber(int number)
  {
    Room room = new Room();

    return room;
  }

  public void add(Room room)
  {
  }

  public void edit(int number)
  {
  }

  public void lock(int number)
  {
  }
}
