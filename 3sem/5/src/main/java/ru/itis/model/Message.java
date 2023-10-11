package ru.itis.model;

public class Message {
    String text;
    String userOutput;
    String userInput;

    public Message(String text, String userOutput, String userInput) {
        this.text = text;
        this.userOutput = userOutput;
        this.userInput = userInput;
    }

    @Override
    public String toString(){
        return userOutput + " : " + text;
    }
}
