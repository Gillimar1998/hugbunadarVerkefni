package com.example.hugbunadarVerkefni.model;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.List;

// Þurfum að gera Macros, og Comment klasa
@Entity
public class Recipe {

    private String name;
    private User user;
    private int recipeID;
    private List<String> ingredients;
    private Macros macros; // Þurfum að gera macros klasa
    private Date cookTime;
    private List<Comment> comments; // Þurfum að gera comment klasa
    private boolean privatePost;

    // Getterar og setterar
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Macros getMacros() {
        return macros;
    }

    public void setMacros(Macros macros) {
        this.macros = macros;
    }

    public Date getCookTime() {
        return cookTime;
    }

    public void setCookTime(Date cookTime) {
        this.cookTime = cookTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isPrivatePost() {
        return privatePost;
    }

    public void setPrivatePost(boolean privatePost) {
        this.privatePost = privatePost;
    }
}
