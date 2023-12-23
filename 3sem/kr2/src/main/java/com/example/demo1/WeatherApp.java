package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather App");

        TextField cityTextField = new TextField();
        Button getWeatherButton = new Button("Get Weather");

        getWeatherButton.setOnAction(event -> {
            String cityName = cityTextField.getText();
            Weather weather = new Weather(cityName);
            weather.getWeather();

            displayWeatherDetails(weather);
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(new Label("Enter City:"), cityTextField, getWeatherButton);

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void displayWeatherDetails(Weather weather) {
        Stage weatherDetailsStage = new Stage();
        weatherDetailsStage.setTitle("Weather Details");

        Image image = new Image("https://openweathermap.org/img/wn/10d@2x.png");
        ImageView imageView = new ImageView(image);

        Label cityLabel = new Label("City: " + weather.getCityName());
        Label descriptionLabel = new Label("Description: " + weather.getDescription());
        Label tempLabel = new Label("Temperature: " + weather.getTemp());
        Label feelsLikeLabel = new Label("Feels Like: " + weather.getFeelsLike());
        Label tempMinLabel = new Label("Min Temperature: " + weather.getTempMin());
        Label tempMaxLabel = new Label("Max Temperature: " + weather.getTempMax());
        Label humidityLabel = new Label("Humidity: " + weather.getHumidity() + "%");
        Label pressureLabel = new Label("Pressure: " + weather.getPressure() + " hPa");
        Label windSpeedLabel = new Label("Wind Speed: " + weather.getWindSpeed() + " m/s");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(imageView, cityLabel, descriptionLabel, tempLabel, feelsLikeLabel,
                tempMinLabel, tempMaxLabel, humidityLabel, pressureLabel, windSpeedLabel);

        Scene scene = new Scene(vbox, 600, 600);
        weatherDetailsStage.setScene(scene);
        weatherDetailsStage.show();
    }
}

