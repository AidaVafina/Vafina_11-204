package org.example.essence.servlets;

import org.example.essence.dao.UserDao;
import org.example.essence.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        String surname = (String) session.getAttribute("surname");
        UserDao userDao = new UserDao();

        try {
            User user = userDao.getUser(name, password, surname);
            request.setAttribute("user", user);

            String contextPath = request.getContextPath();
            String editProfileUrl = contextPath + "/profile.jsp";
            response.sendRedirect(editProfileUrl);
           } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
