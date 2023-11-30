package ru.itis.servlets;

import lombok.SneakyThrows;
import ru.itis.utils.Actions;
import ru.itis.utils.ConnectionContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/createPet")
public class CreatePetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String ownerName = (String) session.getAttribute("name");
        if (ownerName == null) {
            resp.sendRedirect("/servlets/name");
        } else {
            req.getRequestDispatcher("/pages/createPet.jsp").forward(req, resp);
        }
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String[] parameters = extractPetParameters(req, session);
        Connection connection = ConnectionContainer.getConnection();

        Actions.createPet(connection, parameters);

        closeConnection(connection);
        redirectToPetsPage(resp);
    }

    private String[] extractPetParameters(HttpServletRequest req, HttpSession session) {
        String[] parameters = new String[6];
        parameters[0] = (String) session.getAttribute("name");
        parameters[1] = req.getParameter("petName");
        parameters[2] = req.getParameter("type");
        parameters[3] = req.getParameter("age");
        parameters[4] = req.getParameter("sex");
        parameters[5] = req.getParameter("color");
        return parameters;
    }

    @SneakyThrows
    private void closeConnection(Connection connection) {
        if (connection != null) {
            connection.close();
        }
    }

    private void redirectToPetsPage(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/servlets/getPets");
    }
}
