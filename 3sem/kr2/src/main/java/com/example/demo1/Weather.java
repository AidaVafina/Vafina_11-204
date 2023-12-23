package com.example.demo1;

;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Weather {
    private String cityName;
    private String description;
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int humidity;
    private int pressure;
    private double windSpeed;

    public Weather(String cityName) {
        this.cityName = cityName;
    }

    public void getWeather() {
        try {
            String apiKey = "5f5a9a788cc70316af3c41981ba2f54e";
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            parseWeatherData(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseWeatherData(String jsonData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonData);

        description = jsonNode.get("weather").get(0).get("description").asText();
        temp = jsonNode.get("main").get("temp").asDouble();
        feelsLike = jsonNode.get("main").get("feels_like").asDouble();
        tempMin = jsonNode.get("main").get("temp_min").asDouble();
        tempMax = jsonNode.get("main").get("temp_max").asDouble();
        humidity = jsonNode.get("main").get("humidity").asInt();
        pressure = jsonNode.get("main").get("pressure").asInt();
        windSpeed = jsonNode.get("wind").get("speed").asDouble();
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}

