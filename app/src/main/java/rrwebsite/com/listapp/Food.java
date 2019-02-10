package rrwebsite.com.listapp;

public class Food {
    public String name;
    public String description;
    public double calories;
    public double fat;
    public double carbs;
    public double protein;

    @Override
    public String toString() {
        return name + description + calories + fat + carbs + protein;
    }



}







