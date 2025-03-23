package br.com.fiap.model;

public class MenuItem {

	    private String name; // Name of the dish or drink
	    private String description; // Detailed description
	    private double price; // Price of the item
	    private boolean available; // Whether the item is available or not
	    private int calories; // Number of calories
	    private boolean vegan; // Whether it is vegan
	    private boolean glutenFree; // Whether it is gluten-free

	    public MenuItem(String name, String description, double price, boolean available,
	                    int calories, boolean vegan, boolean glutenFree) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.available = available;
	        this.calories = calories;
	        this.vegan = vegan;
	        this.glutenFree = glutenFree;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }
	    public int getCalories() {
	        return calories;
	    }

	    public void setCalories(int calories) {
	        this.calories = calories;
	    }

	    public boolean isVegan() {
	        return vegan;
	    }

	    public void setVegan(boolean vegan) {
	        this.vegan = vegan;
	    }

	    public boolean isGlutenFree() {
	        return glutenFree;
	    }

	    public void setGlutenFree(boolean glutenFree) {
	        this.glutenFree = glutenFree;
	    }

	
    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Price: $" + this.price);
        System.out.println("Available: " + (this.available ? "Yes" : "No"));
        System.out.println("Calories: " + this.calories + " kcal");
        System.out.println("Vegan: " + (this.vegan ? "Yes" : "No"));
        System.out.println("Gluten-Free: " + (this.glutenFree ? "Yes" : "No"));
    }


    public static class Validation {

        public static boolean validatePrice(double price) {
            return price > 0;
        }

        public static boolean validateName(String name) {
            return name != null && !name.isEmpty();
        }
    }

}
