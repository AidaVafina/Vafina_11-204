package org.example.essence.dao;

import org.example.essence.model.User;

import java.sql.*;

public class UserDao {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/users";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "ameliya2022!";

    public void save(User user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, password, surname) " +
                     "SELECT ?, ?, ? WHERE NOT EXISTS (SELECT 1 FROM users WHERE name = ? AND surname = ? AND password = ?)")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getName());
            statement.setString(5, user.getSurname());
            statement.setString(6, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByNameAndPassword(String name, String password, String surname) throws Exception {
        User user = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ? AND surname = ?")) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, surname);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setSurname(resultSet.getString("surname"));
            }
        }
        return user;
    }

    public int getUserId(String name, String password, String surname) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT id_user FROM users WHERE name = ? AND password = ? AND surname = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, surname);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_user");
            } else {
                return 0; // возвращаем 0, если пользователь не найден
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, password = ?, surname = ? WHERE name = ? AND password = ? AND surname = ?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getName());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getSurname());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserName(String name, String password, String surname) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT name FROM users WHERE name = ? AND password = ? AND surname = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, surname);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                return null; // возвращаем null, если пользователь не найден
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public User getUserByUsername(String username) throws Exception {
        User user = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPassword(resultSet.getString("password"));
            }
        }
        return user;
    }

    public User getUser(String name, String password, String surname) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT * FROM users WHERE name = ? AND password = ? AND surname = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, surname);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                return null; // возвращаем null, если пользователь не найден
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}


