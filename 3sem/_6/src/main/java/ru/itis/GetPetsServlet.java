package ru.itis.servlets;

import lombok.SneakyThrows;
import ru.itis.utils.Actions;
import ru.itis.utils.ConnectionContainer;
import ru.itis.model.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/getPets")
public class GetPetsServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = ConnectionContainer.getConnection();
        List<Pet> pets = retrievePets(req, connection);
        closeConnection(connection);
        setPetsAttribute(req, pets);
        forwardToPetsPage(req, resp);
    }

    @SneakyThrows
    private List<Pet> retrievePets(HttpServletRequest req, Connection connection) {
        String username = req.getParameter("user");
        return (username != null) ? Actions.getUserPets(connection, username) : Actions.getAllPets(connection);
    }

    @SneakyThrows
    private void closeConnection(Connection connection) {
        if (connection != null) {
            connection.close();
        }
    }

    private void setPetsAttribute(HttpServletRequest req, List<Pet> pets) {
        req.setAttribute("pets", pets);
    }

    @SneakyThrows
    private void forwardToPetsPage(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher("/pages/getPets.jsp").forward(req, resp);
    }
}
