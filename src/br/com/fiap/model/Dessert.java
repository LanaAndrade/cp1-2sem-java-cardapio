package br.com.fiap.model;

public class Dessert extends MenuItem {
    
    private String dessertType;
    private String flavor;
    private String temperature;
    private String allergens;
    private String sweetnessLevel;
    private String portionSize;
    private String mainIngredients;
    private String healthInfo;

    public Dessert(String name, String description, double price, boolean available
    		, int calories, boolean vegan, boolean glutenFree, String dessertType,
            String flavor, String temperature, String allergens, String sweetnessLevel, String portionSize,
            String mainIngredients, String healthInfo) {
        super(name, description, price, available, calories, vegan, glutenFree);
        this.dessertType = dessertType; // Inicializa tipo de doce
        this.flavor = flavor;
        this.temperature = temperature;
        this.allergens = allergens;
        this.sweetnessLevel = sweetnessLevel;
        this.portionSize = portionSize;
        this.mainIngredients = mainIngredients;
        this.healthInfo = healthInfo;
    }

    public String getDessertType() {
        return dessertType;
    }

    public void setDessertType(String dessertType) {
        this.dessertType = dessertType;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getSweetnessLevel() {
        return sweetnessLevel;
    }

    public void setSweetnessLevel(String sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    public String getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(String portionSize) {
        this.portionSize = portionSize;
    }

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    // Sobrescreve o método para adicionar informações específicas
    @Override
    public void showInfo() {
        super.showInfo(); // Chama o método da classe base
        System.out.println("Dessert Type: " + dessertType); // Exibe tipo de doce
        System.out.println("Flavor: " + flavor); // Exibe sabor
        System.out.println("Temperature: " + temperature); // Exibe temperatura
        System.out.println("Allergens: " + allergens); // Exibe alergênicos
        System.out.println("Sweetness Level: " + sweetnessLevel); // Exibe nível de doçura
        System.out.println("Portion Size: " + portionSize); // Exibe tamanho da porção
        System.out.println("Main Ingredients: " + mainIngredients); // Exibe ingredientes principais
        System.out.println("Health Info: " + healthInfo); // Exibe informações de saúde
    }
}
