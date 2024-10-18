package com.example.hugbunadarVerkefni.controller;

import com.example.hugbunadarVerkefni.model.Recipe;
import com.example.hugbunadarVerkefni.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // "RestController for RESTful services"
@RequestMapping("/recipes")  // URL fyrir recipes
public class RecipeController {
    // Hér erum við að setja "endpoints" fyrir hvar í URL erum við stödd við hverja aðgerð

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/search")  // HTTP GET method
    public List<Recipe> search() {
        return recipeService.search();  // Köllum á service layer
    }


    @GetMapping("/{id}")  // HTTP GET method með path variable
    public Recipe getRecipe(@PathVariable int id) {
        return recipeService.getRecipe(id);  // Köllum á service layer til að fá recipe eftir ID
    }


    @PostMapping  // HTTP POST method
    public Recipe setRecipe(@RequestBody Recipe recipe) {
        return recipeService.setRecipe(recipe);  // Köllum á service layer til að save-a recipe
    }
}
