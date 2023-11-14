package org.example.essence.dao;

import org.example.essence.dao.UserDao;
import org.example.essence.model.Appointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentDao {
    private static final String DBURL = "jdbc:postgresql://localhost:5432/users";
    private static final String DBUSERNAME = "postgres";
    private static final String DBPASSWORD = "ameliya2022!";

    private static final String INSERTAPPOINTMENTSQL = "INSERT INTO public.appointments (iduser, date, \"time\", location, subject) VALUES (?, ?, ?, ?, ?)";

    public void addAppointment(Appointment appointment, String name, String password, String surname) {
        UserDao userDao = new UserDao();
        int userId;
        try {
            userId = userDao.getUserId(name, password, surname);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERTAPPOINTMENTSQL)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setDate(2, new java.sql.Date(appointment.getDate().getTime()));
            preparedStatement.setTime(3, new java.sql.Time(appointment.getTime().getTime()));
            preparedStatement.setString(4, appointment.getLocation());
            preparedStatement.setString(5, appointment.getSubject());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
