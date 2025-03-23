package br.com.fiap.model;

import br.com.fiap.enums.DrinkTemperature;

public class Drink extends MenuItem {

    private boolean alcoholic; // Whether the drink is alcoholic or not
    private String drinkType; // E.g., Soda, Juice, Cocktail, etc.
    private String container; // E.g., Glass, Bottle, Can
    private String flavor; // Flavor of the drink (e.g., Lemon, Orange, etc.)
    private boolean carbonated; // Whether the drink is carbonated or not
    private String size; // E.g., Small, Medium, Large
    private DrinkTemperature drinkTemperature; // Now using the Temperature enum

    // Constructor for the Drink class
    public Drink(String name, String description, double price, String category, boolean available,
                 int preparationTimeMinutes, int calories, boolean vegan, boolean glutenFree, 
                 boolean alcoholic, String drinkType, String container, String flavor, 
                 boolean carbonated, String size, String ingredients, String nutritionInfo, DrinkTemperature drinkTemperature) {
        super(name, description, price, available, calories, vegan, glutenFree);
        this.alcoholic = alcoholic;
        this.drinkType = drinkType;
        this.container = container;
        this.flavor = flavor;
        this.carbonated = carbonated;
        this.size = size;
        this.drinkTemperature = drinkTemperature;
    }

    // Getters and setters
    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public boolean isCarbonated() {
        return carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public DrinkTemperature getDrinkTemperature() {
        return drinkTemperature;
    }

    public void setDrinkTemperature(DrinkTemperature drinkTemperature) {
        this.drinkTemperature = drinkTemperature;
    }

    // Method to print out the details of the drink
    public void printDrinkInfo() {
        System.out.println("Drink Name: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: $" + getPrice());
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
        System.out.println("Calories: " + getCalories() + " kcal");
        System.out.println("Vegan: " + (isVegan() ? "Yes" : "No"));
        System.out.println("Gluten-Free: " + (isGlutenFree() ? "Yes" : "No"));
        System.out.println("Alcoholic: " + (isAlcoholic() ? "Yes" : "No"));
        System.out.println("Drink Type: " + getDrinkType());
        System.out.println("Container: " + getContainer());
        System.out.println("Flavor: " + getFlavor());
        System.out.println("Carbonated: " + (isCarbonated() ? "Yes" : "No"));
        System.out.println("Size: " + getSize());
        System.out.println("Temperature: " + getDrinkTemperature());  // Now it prints Temperature enum value
    }
}
