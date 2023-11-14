package org.example.essence.servlets;

import org.example.essence.dao.UserDao;
import org.example.essence.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String surname = req.getParameter("surname");

        User user = null;
        try {
            user = userDao.getUserByNameAndPassword(username, password, surname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            // регистрация (занесение нового пользователя в БД)
            User newUser = new User();
            newUser.setName(username);
            newUser.setPassword(password);
            newUser.setSurname(surname);
            userDao.save(newUser);

            Cookie cookie = new Cookie("user", username);
            resp.addCookie(cookie);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("/semester_work1/welcome.jsp");
            return;
        }
        // пользователь авторизован

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        resp.sendRedirect("/semester_work1/welcome.jsp");
    }
}
