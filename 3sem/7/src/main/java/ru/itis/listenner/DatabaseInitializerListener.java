package ru.itis.listenner;

import lombok.SneakyThrows;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@WebListener
public class DatabaseInitializerListener implements ServletContextListener {
    @Override
    @SneakyThrows
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/ru/itis/data.sql"));
        String line;
        StringBuilder sql = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            sql.append(line);
        }

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw7",
                "postgres", "ameliya2022!");

        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    @SneakyThrows
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw7",
                "postgres", "ameliya2022!");

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users");
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}