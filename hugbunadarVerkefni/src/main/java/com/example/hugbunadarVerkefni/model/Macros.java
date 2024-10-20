package com.example.hugbunadarVerkefni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Macros {

    @Id
    private int id;  // Gæti verið gott að vera með ID á macros líka

    private int calories;
    private float fat;
    private float carbohydrates;
    private float protein;

    // Getters
    public int getCalories() {
        return calories;
    }

    public float getFat() {
        return fat;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getProtein() {
        return protein;
    }

    // Setters
    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }
}
