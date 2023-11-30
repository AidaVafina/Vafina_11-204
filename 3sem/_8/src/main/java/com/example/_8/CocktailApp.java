package com.example._8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CocktailApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cocktail App");

        Button getCocktailButton = new Button("Get a Cocktail");
        getCocktailButton.setOnAction(e -> showCocktailDialog());

        VBox layout = new VBox(10);
        layout.getChildren().add(getCocktailButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void showCocktailDialog() {
        RandomCocktailReceiver cocktailReceiver = new RandomCocktailReceiver();
        Cocktail cocktail = cocktailReceiver.getRandomCocktail();

        Stage dialogStage = new Stage();
        dialogStage.setTitle(cocktail.getStrDrink());

        VBox dialogLayout = new VBox(10);
        dialogLayout.getChildren().addAll(
                new Label("Instructions: " + cocktail.getStrInstructions()),
                new Label("Alcoholic: " + cocktail.getStrAlcoholic()),
                new Label("Glass: " + cocktail.getStrGlass()),
                new Label("Ingredients: " + cocktail.getStrIngredients())
        );

        Scene dialogScene = new Scene(dialogLayout, 400, 300);
        dialogStage.setScene(dialogScene);

        dialogStage.show();
    }
}