package com.example.hugbunadarVerkefni.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockupRunner {
    public static void main(String[] args) {
        // Þetta er testrunner fyrir recipe

        // Gerum recipe
        Recipe recipe = new Recipe();

        recipe.setName("Chocolate Cake");
        User user = new User("lilja", "lilja@email.is");
        recipe.setUser(user);
        recipe.setRecipeID(1);

        List<String> ingredients = new ArrayList<>();
        ingredients.add("Flour");
        ingredients.add("Sugar");
        ingredients.add("Cocoa powder");
        recipe.setIngredients(ingredients);

        // Búum til macro
        Macros macros = new Macros();
        macros.setCalories(250);
        macros.setFat(10.5f);
        macros.setCarbohydrates(35.0f);
        macros.setProtein(5.0f);
        recipe.setMacros(macros);

        recipe.setCookTime(new Date());

        List<Comment> comments = new ArrayList<>();
        recipe.setComments(comments);

        recipe.setPrivatePost(false);

        // Testing the getters
        // System.out.println("Recipe Name: " + recipe.getName());
        // System.out.println("User: " + recipe.getUser());
        System.out.println("Recipe ID: " + recipe.getRecipeID());
        // System.out.println("Ingredients: " + recipe.getIngredients());
        // System.out.println("Macros: ");
        // System.out.println("  Calories: " + recipe.getMacros().getCalories());
        // System.out.println("  Fat: " + recipe.getMacros().getFat());
        // System.out.println("  Carbohydrates: " + recipe.getMacros().getCarbohydrates());
        // System.out.println("  Protein: " + recipe.getMacros().getProtein());
        // System.out.println("Cook Time: " + recipe.getCookTime());
        // System.out.println("Comments: " + recipe.getComments());
        // System.out.println("Is Private Post: " + recipe.isPrivatePost());
    }
}
