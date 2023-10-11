package ru.itis.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class MessageServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        List<String> messages = new ArrayList<>();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("messages", messages);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Do nothing
    }
}
