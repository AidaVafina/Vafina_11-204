package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WeatherController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

