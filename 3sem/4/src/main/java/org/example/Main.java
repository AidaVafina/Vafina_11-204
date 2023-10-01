package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filePath = "/Users/79874/Desktop/Vafina_11-204/3sem/2/index.html";
        File file = new File(filePath);

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = resp.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        BufferedReader reader = req.getReader();
        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
        List<Integer> list = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            list.add(element.getAsInt());
        }
        int sum = list.stream()
                .filter(e -> e > 5)
                .mapToInt(Integer::intValue)
                .sum();
        resp.getWriter().write("Sum of numbers greater than 5: " + sum + "\n");
    }
}
