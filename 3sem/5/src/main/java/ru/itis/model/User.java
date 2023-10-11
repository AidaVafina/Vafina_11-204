package ru.itis.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;

    public List<Message> outputMessage = new ArrayList<>();
    public List<Message> inputMessage = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }
}
