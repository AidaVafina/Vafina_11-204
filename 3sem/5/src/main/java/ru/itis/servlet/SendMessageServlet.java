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

public class SendMessageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (name == null || name.isEmpty()) {
            response.sendRedirect("/5/name");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            out.println("<h2>Send Message:</h2>");
            out.println("<form action=\"sendMessage\" method=\"post\">");
            out.println("<input type=\"text\" name=\"recipient\" placeholder=\"Recipient name\"><br>");
            out.println("<textarea name=\"message\" placeholder=\"Enter your message\"></textarea><br>");
            out.println("<input type=\"submit\" value=\"Send\">");
            out.println("</form>");
            out.println("</body></html>");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");

        if (name == null || name.isEmpty() || UserRep.findUser(name) == null) {
            response.sendRedirect("/5/name");
        } else {
            String recipient = request.getParameter("recipient");
            String message_text = request.getParameter("message");

            if (UserRep.findUser(recipient) != null) {
                Message message = new Message(message_text,name,recipient);
                UserRep.findUser(name).outputMessage.add(message);
                UserRep.findUser(recipient).inputMessage.add(message);
            }
            response.sendRedirect("/5/sendMessage");
        }
    }
}
