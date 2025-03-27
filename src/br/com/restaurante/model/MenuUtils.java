package br.com.restaurante.model;

public final class MenuUtils {
    
    // Removed the instance field 'availability' as it is not needed here
    // private boolean availability; 
    
    // Static method to validate price
    public static boolean validatePrice(double price) {
        return price > 0;
    }

    // Static method to validate availability
    public static boolean validateAvailability(boolean disponivel) {
        return disponivel; // Now accepts 'disponivel' as a parameter
    }
}
