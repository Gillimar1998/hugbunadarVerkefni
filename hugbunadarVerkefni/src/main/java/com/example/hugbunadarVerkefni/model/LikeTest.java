package com.example.hugbunadarVerkefni.model;

import com.example.hugbunadarVerkefni.implement.RecipeServiceImpl;
import com.example.hugbunadarVerkefni.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class LikeTest {

    // Mock implementation of RecipeRepository
    private static RecipeRepository mockRecipeRepository = new RecipeRepository() {
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
        public void createRecipe(Recipe recipe) {
            recipes.add(recipe); // Adding to the mock repository
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
        public Recipe searchRecipeByID(Long recipeId) {
            return recipes.stream()
                    .filter(recipe -> recipe.getRecipeID() == recipeId)
                    .findFirst()
                    .orElse(null); // Return the recipe if found, otherwise null
        }
    };

    public static void main(String[] args) {
        // Create an instance of RecipeServiceImpl with the mock repository
        RecipeServiceImpl recipeService = new RecipeServiceImpl(mockRecipeRepository);

        // Create a new recipe
        Recipe recipe = new Recipe();
        recipe.setName("Chocolate Cake");
        recipe.setRecipeID(1);  // Set the recipe ID

        // Add user, ingredients, macros, comments, and other attributes
        User user1 = new User("Lilja", "lilja@email.is");
        User user2 = new User("Gilli", "gilli@email.is");

        // Create macros
        Macros macros = new Macros();
        macros.setCalories(250);
        macros.setFat(10.5f);
        macros.setCarbohydrates(35.0f);
        macros.setProtein(5.0f);
        recipe.setMacros(macros);
        recipe.setCookTime(new Date());
        recipe.setUser(user1);
        recipe.setIngredients(new ArrayList<>(List.of("Flour", "Sugar", "Cocoa powder")));
        recipe.setComments(new ArrayList<>());
        recipe.setPrivatePost(false);

        // Save the recipe
        recipeService.setRecipe(recipe);

        // User 1 likes the recipe
        List<Long> likesFromUser1 = recipeService.likeARecipe((long) recipe.getRecipeID(), 1L);
        System.out.println("User 1 liked the recipe. Current likes: " + likesFromUser1.size()); // Should be 1

        // User 2 likes the recipe
        List<Long> likesFromUser2 = recipeService.likeARecipe((long) recipe.getRecipeID(), 2L);
        System.out.println("User 2 liked the recipe. Current likes: " + likesFromUser2.size()); // Should be 2

        // User 1 tries to like the recipe again
        List<Long> likesFromUser1Again = recipeService.likeARecipe((long) recipe.getRecipeID(), 1L);
        System.out.println("User 1 tried to like the recipe again. Current likes: " + likesFromUser1Again.size()); // Should still be 2

        // Retrieve and print the recipe details
        Recipe retrievedRecipe = recipeService.getRecipe((long) recipe.getRecipeID());
        System.out.println("Recipe Name: " + retrievedRecipe.getName());
        System.out.println("Total Likes: " + retrievedRecipe.getLikeCount());
    }
}
