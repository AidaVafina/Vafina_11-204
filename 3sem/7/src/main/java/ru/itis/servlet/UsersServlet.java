package ru.itis.servlet;

import lombok.Builder;
import lombok.SneakyThrows;
import ru.itis.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> usersList = retrieveUsersFromDatabase();
        req.setAttribute("users", usersList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/users.jsp");
        dispatcher.forward(req, resp);
    }

    @SneakyThrows
    private List<User> retrieveUsersFromDatabase() {
        List<User> usersList = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw7",
                "postgres", "ameliya2022!");

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            usersList.add(User.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .age(resultSet.getInt("age"))
                    .sex(resultSet.getString("sex"))
                    .email(resultSet.getString("email"))
                    .build());
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return usersList;
    }
}