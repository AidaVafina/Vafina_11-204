package com.example._8;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class RandomCocktailReceiver {
    public Cocktail getRandomCocktail() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://www.thecocktaildb.com/api/json/v1/1/random.php")
                    .build();

            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            JSONObject json = new JSONObject(responseData);
            JSONObject drink = json.getJSONArray("drinks").getJSONObject(0);

            String strDrink = drink.optString("strDrink", "");
            String strInstructions = drink.optString("strInstructions", "");
            String strAlcoholic = drink.optString("strAlcoholic", "");
            String strGlass = drink.optString("strGlass", "");
            String strIngredients = getIngredientsList(drink);

            return new Cocktail(strDrink, strInstructions, strAlcoholic, strGlass, strIngredients);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getIngredientsList(JSONObject drink) {
        StringBuilder ingredientsList = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            String ingredient = drink.optString("strIngredient" + i, null);
            if (ingredient != null) {
                if (ingredientsList.length() > 0) {
                    ingredientsList.append(", ");
                }
                ingredientsList.append(ingredient);
            }
        }
        return ingredientsList.toString();
    }
}
