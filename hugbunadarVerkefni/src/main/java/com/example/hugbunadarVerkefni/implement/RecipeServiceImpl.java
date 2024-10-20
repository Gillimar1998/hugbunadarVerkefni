package com.example.hugbunadarVerkefni.implement;

import com.example.hugbunadarVerkefni.model.Recipe;
import com.example.hugbunadarVerkefni.repository.RecipeRepository;
import com.example.hugbunadarVerkefni.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    // hér þarf að laga aðferðir til að þær virki almennilega

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
        return recipeRepository.findAll(); // Hér getum við breytt þessu ef þetta virkar ekki
    }

    @Override
    public Recipe getRecipe(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @Override
    public Recipe setRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> searchByName(String name) {
        return recipeRepository.findAll().stream()
                .filter(recipe -> recipe.getName().toLowerCase().contains(name.toLowerCase()))
                .toList(); // Java 16+; otherwise, use a for loop to collect results
    }

    @Override
    public List<Long> likeARecipe(Long recipeId, Long userId) {
        // Náum í recipe úr repository
        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);

        if (recipe != null) {
            if (!recipe.getLikedUserIDs().contains(userId)) {
                // Setur UserID í lista af users sem like-a
                recipe.getLikedUserIDs().add(userId);
                recipeRepository.save(recipe);
            } else {
                // Soldið Error message sem segir okkur ef userinn eru búinn að likea núþegar
                System.out.println("User has already liked this recipe.");
            }
        }

        // Skilar lista af userIDs sem hafa like-að recipe-ið
        return recipe != null ? recipe.getLikedUserIDs() : new ArrayList<>();
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
