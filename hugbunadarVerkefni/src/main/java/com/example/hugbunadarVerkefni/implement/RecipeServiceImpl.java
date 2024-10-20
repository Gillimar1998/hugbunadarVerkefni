package com.example.hugbunadarVerkefni.implement;

import com.example.hugbunadarVerkefni.model.Recipe;
import com.example.hugbunadarVerkefni.repository.RecipeRepository;
import com.example.hugbunadarVerkefni.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe searchRecipeByID(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @Override
    public List<Recipe> search() {
        return recipeRepository.findAll(); // Or any custom logic for searching
    }

    @Override
    public Recipe getRecipe(Long recipeId) { // Implement the getRecipe method
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @Override
    public Recipe setRecipe(Recipe recipe) {  // Implement the setRecipe method
        return recipeRepository.save(recipe);  // Assuming save() will create or update the recipe
    }

    @Override
    public List<Recipe> searchByName(String name) {
        return recipeRepository.searchByName(name);
    }

    @Override
    public List<Recipe> likeARecipe(Long recipeId, Long userId) {
        // Fetch the recipe from the repository
        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);
        if (recipe != null) {
            // Increment the like count
            recipe.setLikeCount(recipe.getLikeCount() + 1);
            // Save the updated recipe back to the repository
            recipeRepository.save(recipe);
        }
        // Return the updated list of liked recipes (if needed)
        return recipeRepository.findAll(); // Adjust this as necessary for your use case
    }


    @Override
    public void editRecipe(Recipe recipe) {
        recipeRepository.editRecipe(recipe);
    }

    @Override
    public Boolean recipeVisibility(Long recipeId) {
        return recipeRepository.recipeVisibility(recipeId);
    }

    @Override
    public void editComment(Long commentId, String newContent) {
        recipeRepository.editComment(commentId, newContent);
    }

    @Override
    public void deleteComment(Long commentId) {
        recipeRepository.deleteComment(commentId);
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteRecipe(recipeId);
    }

    @Override
    public void unLike(Long recipeId, Long userId) {
        recipeRepository.unLike(recipeId, userId);
    }

    @Override
    public void deleteRating(Long ratingId) {
        recipeRepository.deleteRating(ratingId);
    }

    @Override
    public void comment(Long recipeId, String commentContent, Long userId) {
        recipeRepository.comment(recipeId, commentContent, userId);
    }

    @Override
    public void rate(Long recipeId, int ratingValue, Long userId) {
        recipeRepository.rate(recipeId, ratingValue, userId);
    }

    @Override
    public List<Recipe> sortRecipes(String criteria) {
        return recipeRepository.sortRecipes(criteria);
    }

    @Override
    public List<String> getCategories() {
        return recipeRepository.getCategories();
    }

    @Override
    public void createRecipe(Recipe recipe) {
        recipeRepository.createRecipe(recipe);
    }

    @Override
    public List<Recipe> sortRecipesByDate() {
        return recipeRepository.sortRecipesByDate();
    }

    @Override
    public List<Recipe> searchByIngredient(String ingredient) {
        return recipeRepository.searchByIngredient(ingredient);
    }
}
