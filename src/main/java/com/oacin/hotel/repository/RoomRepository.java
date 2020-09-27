package com.oacin.hotel.repository;

import com.oacin.hotel.model.Room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

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

    String query = "SELECT number, floor, type, capacity FROM room";

    try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while(rs.next())
      {
        Room room = new Room();

        room.setNumber(rs.getInt("number"));
        room.setFloor(rs.getString("floor"));
        room.setType(rs.getString("type"));
        room.setCapacity(rs.getInt("capacity"));

        rooms.add(room);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rooms;
  }

  public Room findByNumber(int number)
  {
    Room room = new Room();

    String query = String.format("SELECT number, floor, type, capacity FROM room " + 
    "WHERE number = %s", number);

    try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while(rs.next())
      {
        room.setNumber(rs.getInt("number"));
        room.setFloor(rs.getString("floor"));
        room.setType(rs.getString("type"));
        room.setCapacity(rs.getInt("capacity"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

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
