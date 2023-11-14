package org.example.essence.servlets;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/bookadd")
public class BookAddServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/bookadd.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        Integer age = Integer.parseInt(request.getParameter("age"));
//        String description = request.getParameter("description");
//
//        UserDao userDao = new UserDao();
//
//        Integer userId = 0;
//        try {
//            String name = request.getParameter("name");
//            String password = request.getParameter("password");
//            String surname = request.getParameter("surname");
//            userId = userDao.getUserId(name, password, surname);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        Book book = new Book();
//        book.setTitle(title);
//        book.setAuthor(author);
//        book.setAge(age);
//        book.setDescription(description);
//        book.setUserId(userId);
//
//        BookDao bookDao = new BookDao();
//        bookDao.addBookToDatabase(book);
//
//        request.getRequestDispatcher("/semester_work1/bookadded.jsp").forward(request, response);
//    }
}

