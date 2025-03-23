package br.com.fiap.model;

public class MainCourse extends MenuItem {

    private String mainCourseType; // Tipo de prato principal (e.g., Grilled, Steamed, Roasted)
    private String cookingMethod; // Método de preparo (e.g., Roasted, Grilled, Sautéed)
    private String spiceLevel; // Nível de pimenta (e.g., Mild, Medium, Spicy)
    private String servingStyle; // Estilo de servir (e.g., On a plate, in a bowl)
    private String dietaryPreferences; // Preferências dietéticas (e.g., Keto, Low-Carb, High-Protein)
    private boolean organic; // Se os ingredientes são orgânicos
    private String source; // Origem dos ingredientes (e.g., Local, Imported)
    private boolean halal; // Se o prato é halal
    private boolean kosher; // Se o prato é kosher

    // Construtor para a classe MainCourse
    public MainCourse(String name, String description, double price, boolean available,
            int calories, boolean vegan, boolean glutenFree, String mainCourseType,
                      String spiceLevel, String servingStyle, String dietaryPreferences,
                      boolean organic, String source, boolean halal, boolean kosher) {
        super(name, description, price, kosher, calories, vegan, glutenFree);
        this.mainCourseType = mainCourseType;
        this.cookingMethod = cookingMethod;
        this.spiceLevel = spiceLevel;
        this.servingStyle = servingStyle;
        this.dietaryPreferences = dietaryPreferences;
        this.organic = organic;
        this.source = source;
        this.halal = halal;
        this.kosher = kosher;
    }

    // Getters e Setters
    public String getMainCourseType() {
        return mainCourseType;
    }

    public void setMainCourseType(String mainCourseType) {
        this.mainCourseType = mainCourseType;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public String getServingStyle() {
        return servingStyle;
    }

    public void setServingStyle(String servingStyle) {
        this.servingStyle = servingStyle;
    }

    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    // Sobrescreve o método para exibir informações específicas para pratos principais
    @Override
    public void showInfo() {
        super.showInfo(); // Chama o método da classe base
        System.out.println("Main Course Type: " + mainCourseType); // Exibe o tipo de prato principal
        System.out.println("Cooking Method: " + cookingMethod); // Exibe o método de preparo
        System.out.println("Spice Level: " + spiceLevel); // Exibe o nível de pimenta
        System.out.println("Serving Style: " + servingStyle); // Exibe o estilo de servir
        System.out.println("Dietary Preferences: " + dietaryPreferences); // Exibe preferências dietéticas
        System.out.println("Organic: " + (organic ? "Yes" : "No")); // Exibe se é orgânico
        System.out.println("Source: " + source); // Exibe a origem dos ingredientes
        System.out.println("Halal: " + (halal ? "Yes" : "No")); // Exibe se é halal
        System.out.println("Kosher: " + (kosher ? "Yes" : "No")); // Exibe se é kosher
    }
}
