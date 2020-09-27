package com.oacin.hotel.repository;

import com.oacin.hotel.model.Booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BookingRepository {
  private final JdbcTemplate jdbcTemplate;

  public BookingRepository(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Booking> findAll()
  {
    List<Booking> bookings = new ArrayList<>();

    String query = "SELECT id, room, startDate, endDate, price, guest FROM booking";

    try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while(rs.next())
      {
        Booking booking = new Booking();

        booking.setId(rs.getInt("id"));
        booking.setRoom(rs.getInt("room"));
        booking.setStartDate(rs.getDate("startDate"));
        booking.setEndDate(rs.getDate("endDate"));
        booking.setPrice(rs.getFloat("price"));
        booking.setGuest(rs.getString("guest"));

        bookings.add(booking);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return bookings;
  }
}
