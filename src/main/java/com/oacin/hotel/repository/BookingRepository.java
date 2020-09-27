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

  public Booking findById(int id)
  {
    Booking booking = new Booking();

    String query = String.format("SELECT id, room, startDate, endDate, price, guest FROM booking WHERE id = %s", id);

    try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
      Statement st = conn.createStatement();
      
      ResultSet rs = st.executeQuery(query);

      while(rs.next())
      {
        booking.setId(rs.getInt("id"));
        booking.setRoom(rs.getInt("room"));
        booking.setStartDate(rs.getDate("startDate"));
        booking.setEndDate(rs.getDate("endDate"));
        booking.setPrice(rs.getFloat("price"));
        booking.setGuest(rs.getString("guest"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return booking;
  }

  public void add(Booking booking)
  {
    String insert = "INSERT INTO booking(room, startDate, endDate, price, guest) VALUES(?, ?, ?, ?, ?)";

    try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
      conn.setAutoCommit(false);
      
      PreparedStatement pst = conn.prepareStatement(insert);

      pst.setInt(1, booking.getRoom());
      pst.setDate(2, booking.getStartDate());
      pst.setDate(3, booking.getEndDate());
      pst.setFloat(4, booking.getPrice());
      pst.setString(5, booking.getGuest());

      int affectedRows = pst.executeUpdate();

      if (affectedRows > 0) {
        conn.commit();

        System.out.println("A new booking has been made");
      } else {
        conn.rollback();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void destroy(int id)
  {
    String delete = String.format("DELETE FROM booking WHERE id = %s", id);

    try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
      conn.setAutoCommit(false);

      PreparedStatement pst = conn.prepareStatement(delete);

      int affectedRows = pst.executeUpdate();

      if (affectedRows > 0) {
        conn.commit();

        System.out.println(String.format("Booking %s has been deleted", id));
      } else {
        conn.rollback();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
