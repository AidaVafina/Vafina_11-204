package org.example.essence.servlets;

import org.example.essence.dao.UserDao;
import org.example.essence.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editProfile")
public class EditProfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        String surname = (String) session.getAttribute("surname");
        UserDao userDao = new UserDao();

        try {
            User user = userDao.getUser(name, password, surname);
            request.setAttribute("user", user);

            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        String surname = (String) session.getAttribute("surname");
        UserDao userDao = new UserDao();

        try {
            User user = userDao.getUser(name, password, surname);

            // Обновление данных пользователя
            String newName = request.getParameter("newName");
            String newSurname = request.getParameter("newSurname");
            String newPassword = request.getParameter("newPassword");
            user.setName(newName);
            user.setSurname(newSurname);
            user.setPassword(newPassword);
            // сохранение изменений в базе данных
            userDao.updateUser(user);

            // Обновление данных в сессии
            session.setAttribute("name", user.getName());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("surname", user.getSurname());

            request.setAttribute("user", user);

            response.sendRedirect("/profile.jsp");
             } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
