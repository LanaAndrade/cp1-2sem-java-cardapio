package br.com.fiap.model;

public class Entree extends MenuItem {

    private String entreeType; // Type of entrée (e.g., Grilled, Fried, Steamed, etc.)
    private String portionSize; // Portion size (e.g., Small, Medium, Large)
    private String mainIngredients; // Main ingredients (e.g., Chicken, Beef, Vegetables)
    private String servingMethod; // How the entrée is served (e.g., On a plate, With a side, etc.)

    // Constructor for the Entree class
    public Entree(String name, String description, double price, boolean available, int calories, boolean vegan, boolean glutenFree, String entreeType,
                  String portionSize, String mainIngredients, String servingMethod) {
        super(name, description, price, available, calories, vegan, glutenFree);
        this.entreeType = entreeType;
        this.portionSize = portionSize;
        this.mainIngredients = mainIngredients;
        this.servingMethod = servingMethod;
    }

    // Getter and Setter for entreeType
    public String getEntreeType() {
        return entreeType;
    }

    public void setEntreeType(String entreeType) {
        this.entreeType = entreeType;
    }

    // Getter and Setter for portionSize
    public String getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(String portionSize) {
        this.portionSize = portionSize;
    }

    // Getter and Setter for mainIngredients
    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    // Getter and Setter for servingMethod
    public String getServingMethod() {
        return servingMethod;
    }

    public void setServingMethod(String servingMethod) {
        this.servingMethod = servingMethod;
    }

    // Overriding the method to display specific information for entrées
    @Override
    public void showInfo() {
        super.showInfo(); // Calls the base class method
        System.out.println("Entree Type: " + entreeType); // Displays type of entrée
        System.out.println("Portion Size: " + portionSize); // Displays portion size
        System.out.println("Main Ingredients: " + mainIngredients); // Displays main ingredients
        System.out.println("Serving Method: " + servingMethod); // Displays serving method
    }
}
