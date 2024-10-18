package com.example.hugbunadarVerkefni.repository;

import com.example.hugbunadarVerkefni.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Hér þarf að klára þessar aðferðir

    List<Recipe> searchByName(String name);


    List<Recipe> likeARecipe(Long recipeId, Long userId); // Hér er áætlað að við þurfum userId til að


    void editRecipe(Recipe recipe);


    Boolean recipeVisibility(Long recipeId);


    void editComment(Long commentId, String newContent);


    void deleteComment(Long commentId);


    void deleteRecipe(Long recipeId);


    void unLike(Long recipeId, Long userId);


    void deleteRating(Long ratingId);


    void comment(Long recipeId, String commentContent, Long userId);


    void rate(Long recipeId, int ratingValue, Long userId);


    List<Recipe> sortRecipes(String criteria); // Hérna tökum við inn skilyrði til að bera samn við


    List<String> getCategories();


    void createRecipe(Recipe recipe);


    List<Recipe> sortRecipesByDate();


    List<Recipe> searchByIngredient(String ingredient);

    // Ekki notuð? - skilum frekar einni recipe heldur en mörgum.
    Recipe searchRecipeByID(Long recipeId);
}
