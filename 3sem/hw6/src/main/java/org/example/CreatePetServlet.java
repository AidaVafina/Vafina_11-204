package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/createPet")
public class CreatePetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/createPet.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            response.sendRedirect("http://localhost:8080/servlets/name");
        } else {
            String ownerName = session.getAttribute("name").toString();
            String petName = request.getParameter("petName");
            double height = Double.parseDouble(request.getParameter("height"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            String color = request.getParameter("color");
            String sex = request.getParameter("sex");

            // 1. Установить подключение к БД
            Connection connection = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw6", "postgres", "ameliya2022!");

                // 2. Подготовить SQL-запрос для вставки записи о питомце
                String sql = "INSERT INTO pet (name, sex, colour, height, weight, owner) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, petName);
                statement.setString(2, sex);
                statement.setString(3, color);
                statement.setDouble(4, height);
                statement.setDouble(5, weight);
                statement.setString(6, ownerName);

                // 3. Выполнить SQL-запрос
                statement.executeUpdate();

                // 4. Закрыть PreparedStatement и соединение с БД
                statement.close();
                connection.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("http://localhost:8080/servlets/createPet");
        }
    }
}