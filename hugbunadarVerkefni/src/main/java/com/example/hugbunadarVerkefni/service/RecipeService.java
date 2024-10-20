package com.example.hugbunadarVerkefni.service;

import com.example.hugbunadarVerkefni.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe searchRecipeByID(Long recipeId);

    List<Recipe> search();

    Recipe getRecipe(Long recipeId);

    Recipe setRecipe(Recipe recipe);

    List<Recipe> searchByName(String name);

    List<Long> likeARecipe(Long recipeId, Long userId);

    void editRecipe(Recipe recipe);

    Boolean recipeVisibility(Long recipeId);

    void editComment(Long commentId, String newContent);

    void deleteComment(Long commentId);

    void deleteRecipe(Long recipeId);

    void unLike(Long recipeId, Long userId);

    void deleteRating(Long ratingId);

    void comment(Long recipeId, String commentContent, Long userId);

    void rate(Long recipeId, int ratingValue, Long userId);

    List<Recipe> sortRecipes(String criteria);

    List<String> getCategories();

    void createRecipe(Recipe recipe);

    List<Recipe> sortRecipesByDate();

    List<Recipe> searchByIngredient(String ingredient);
}
