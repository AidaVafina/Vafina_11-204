package org.example.essence.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/org.example.essence.servlets.SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // полаем значение, введенное пользователем в форме
        String query = request.getParameter("query");


        // отправляем результаты в качестве ответа на запрос
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<table>");

        out.println("</table>");
        out.println("</body></html>");
    }
}
