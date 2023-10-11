package ru.itis.servlet;

import ru.itis.model.Message;
import ru.itis.repository.UserRep;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class GetMessageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");

        if (name == null || name.isEmpty() || UserRep.findUser(name) == null) {
            response.sendRedirect("/5/name");
        } else {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            out.println("<h2>Messages:</h2>");
            for (Message message : UserRep.findUser(name).inputMessage) {
                out.println("<p>" + message.toString() + "</p>");
            }
            out.println("</body></html>");
        }
    }
}
