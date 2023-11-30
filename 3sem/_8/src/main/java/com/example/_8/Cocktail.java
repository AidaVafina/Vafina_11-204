package com.example._8;

public class Cocktail {
    private String strDrink;
    private String strInstructions;
    private String strAlcoholic;
    private String strGlass;
    private String strIngredients;

    public Cocktail(String strDrink, String strInstructions, String strAlcoholic, String strGlass, String strIngredients) {
        this.strDrink = strDrink;
        this.strInstructions = strInstructions;
        this.strAlcoholic = strAlcoholic;
        this.strGlass = strGlass;
        this.strIngredients = strIngredients;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public String getStrIngredients() {
        return strIngredients;
    }
}
