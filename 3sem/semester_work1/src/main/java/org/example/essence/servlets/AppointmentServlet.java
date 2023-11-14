package org.example.essence.servlets;

import org.example.essence.dao.AppointmentDao;
import org.example.essence.model.Appointment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calendar")
public class AppointmentServlet extends HttpServlet {

    private AppointmentDao appointmentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        appointmentDao = new AppointmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/calendar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String location = request.getParameter("location");
        String subject = request.getParameter("subject");

        // Create Appointment object
        Date appointmentDate = null;
        try {
            appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date appointmentTime = null;
        try {
            appointmentTime = new SimpleDateFormat("HH:mm").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Appointment appointment = new Appointment();
        appointment.setDate(appointmentDate);
        appointment.setTime(appointmentTime);
        appointment.setLocation(location);
        appointment.setSubject(subject);

        // Add appointment to database
        String name = (String) request.getSession().getAttribute("name");
        String password = (String) request.getSession().getAttribute("password");
        String surname = (String) request.getSession().getAttribute("surname");
        appointmentDao.addAppointment(appointment, name, password, surname);

        response.sendRedirect(request.getContextPath() + "/appointments/success.jsp");
    }
}