package ru.itis.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/name")
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToNamePage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = extractNameParameter(req);
        saveNameToSession(req, name);
        redirectToCreatePetPage(resp);
    }

    private void forwardToNamePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/nameForm.jsp").forward(req, resp);
    }

    private String extractNameParameter(HttpServletRequest req) {
        return req.getParameter("name");
    }

    private void saveNameToSession(HttpServletRequest req, String name) {
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
    }

    private void redirectToCreatePetPage(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/createPet");
    }
}
