package ru.itis.servlet;

import ru.itis.repository.UserRep;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Enter your name:</h2>");
        out.println("<form action=\"name\" method=\"post\">");
        out.println("<input type=\"text\" name=\"name\">");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        System.out.println(name);

        if (name != null && !name.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);

            UserRep.addUser(name);

            response.sendRedirect("/5/sendMessage");
        } else {
            response.sendRedirect("/name");
        }
    }
}


