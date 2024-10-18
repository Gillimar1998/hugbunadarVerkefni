package com.example.hugbunadarVerkefni.service;

import com.example.hugbunadarVerkefni.model.Recipe;
import com.example.hugbunadarVerkefni.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    // Notum aðferðir úr repository

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public Recipe searchRecipeByID(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null); // Skilar Null ef recipe finnst ekki
    }


    public List<Recipe> searchByName(String name) {
        return recipeRepository.searchByName(name);
    }


    public List<Recipe> likeARecipe(Long recipeId, Long userId) {
        // Hér þurfum við að gera Like a recipe
        return recipeRepository.likeARecipe(recipeId, userId);
    }


    public void editRecipe(Recipe recipe) {
        recipeRepository.editRecipe(recipe);
    }


    public Boolean recipeVisibility(Long recipeId) {
        return recipeRepository.recipeVisibility(recipeId);
    }


    public void editComment(Long commentId, String newContent) {
        recipeRepository.editComment(commentId, newContent);
    }


    public void deleteComment(Long commentId) {
        recipeRepository.deleteComment(commentId);
    }


    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteRecipe(recipeId);
    }


    public void unLike(Long recipeId, Long userId) {
        recipeRepository.unLike(recipeId, userId);
    }


    public void deleteRating(Long ratingId) {
        recipeRepository.deleteRating(ratingId);
    }


    public void comment(Long recipeId, String commentContent, Long userId) {
        recipeRepository.comment(recipeId, commentContent, userId);
    }


    public void rate(Long recipeId, int ratingValue, Long userId) {
        recipeRepository.rate(recipeId, ratingValue, userId);
    }


    public List<Recipe> sortRecipes(String criteria) {
        return recipeRepository.sortRecipes(criteria);
    }


    public List<String> getCategories() {
        return recipeRepository.getCategories();
    }


    public void createRecipe(Recipe recipe) {
        recipeRepository.createRecipe(recipe);
    }


    public List<Recipe> sortRecipesByDate() {
        return recipeRepository.sortRecipesByDate();
    }


    public List<Recipe> searchByIngredient(String ingredient) {
        return recipeRepository.searchByIngredient(ingredient);
    }
}

