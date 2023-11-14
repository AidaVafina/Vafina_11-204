package org.example.essence.dao;

import org.example.essence.utils.ConnectionContainer;
import org.example.essence.model.Book;

import java.sql.*;


public class BookDao {
    final private static String SQL_ADD_BOOK = "INSERT INTO books (title, author, age, description, user_id) VALUES (?, ?, ?, ?, ?)";
    final private static String SQL_FIND_BOOK_BY_ID = "SELECT title, author, age, description, user_id FROM books WHERE id = ?";
    final private static String SQL_FIND_BOOKS_BY_USER_ID = "SELECT id, title, author, age, description FROM books WHERE user_id = ?";
    final private static String SQL_DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    final private static String SQL_GET_ALL_BOOKS_WITH_USERNAMES_AND_BOOKID =
            """
            SELECT 
                (SELECT username FROM users WHERE users.id = books.user_id) AS username,
                books.id AS book_id,
                books.title,
                books.author,
                books.age,
                books.description
            FROM books;
            """;

    public void addBookToDatabase(Book book) {
        try (Connection connection = ConnectionContainer.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getAge());
            statement.setString(4, book.getDescription());
            statement.setInt(5, book.getUserId());

            UserDao userDao = new UserDao();

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    int bookId = resultSet.getInt(1); // Возвращаем ID книги
                    book.setBookId(bookId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

