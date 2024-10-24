package com.example.hugbunadarVerkefni.model;

import com.example.hugbunadarVerkefni.implement.RecipeServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockupRunner {
    // til þess að athuga virkni skipana tengd recipe.

    /*private static RecipeRepository mockRecipeRepository = new RecipeRepository() {
        private List<Recipe> recipes = new ArrayList<>();

        @Override
        public <S extends Recipe> S save(S entity) {
            recipes.add(entity);
            return entity;
        }

        @Override
        public Optional<Recipe> findById(Long id) {
            return recipes.stream().filter(recipe -> recipe.getRecipeID() == id).findFirst();
        }

        @Override
        public List<Recipe> findAll() {
            return new ArrayList<>(recipes);
        }

        @Override
        public List<Recipe> searchByName(String name) {
            return null; // Placeholder implementation
        }

        @Override
        public List<Recipe> likeARecipe(Long recipeId, Long userId) {
            return null; // Placeholder implementation
        }

        @Override
        public void editRecipe(Recipe recipe) {
            // Placeholder implementation
        }

        @Override
        public Boolean recipeVisibility(Long recipeId) {
            return null; // Placeholder implementation
        }

        @Override
        public void editComment(Long commentId, String newContent) {
            // Placeholder implementation
        }

        @Override
        public void deleteComment(Long commentId) {
            // Placeholder implementation
        }

        @Override
        public void deleteRecipe(Long recipeId) {
            // Placeholder implementation
        }

        @Override
        public void unLike(Long recipeId, Long userId) {
            // Placeholder implementation
        }

        @Override
        public void deleteRating(Long ratingId) {
            // Placeholder implementation
        }

        @Override
        public void comment(Long recipeId, String commentContent, Long userId) {
            // Placeholder implementation
        }

        @Override
        public void rate(Long recipeId, int ratingValue, Long userId) {
            // Placeholder implementation
        }

        @Override
        public List<Recipe> sortRecipes(String criteria) {
            return null; // Placeholder implementation
        }

        @Override
        public List<String> getCategories() {
            return null; // Placeholder implementation
        }

        @Override
        public List<Recipe> sortRecipesByDate() {
            return null; // Placeholder implementation
        }

        @Override
        public List<Recipe> searchByIngredient(String ingredient) {
            return null; // Placeholder implementation
        }

        @Override
        public void createRecipe(Recipe recipe) { // Implement createRecipe method
            recipes.add(recipe);
        }

        @Override
        public Recipe searchRecipeByID(Long recipeId) {
            return recipes.stream()
                    .filter(recipe -> recipe.getRecipeID() == recipeId)
                    .findFirst()
                    .orElse(null);
        }
    };

     */


    public static void main(String[] args) {
        // Þetta er testrunner fyrir recipe

        RecipeServiceImpl recipeService = new RecipeServiceImpl(mockRecipeRepository);

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

        // Save recipe
        recipeService.setRecipe(recipe);

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

        /*
        Recipe retrievedRecipe = recipeService.getRecipe((long) recipe.getRecipeID());
        System.out.println("Recipe gotten by ID: " + (retrievedRecipe != null ? retrievedRecipe.getName() : "Not found"));
        */

    }


}
