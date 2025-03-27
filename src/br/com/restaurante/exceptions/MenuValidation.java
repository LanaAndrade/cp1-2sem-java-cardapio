package br.com.restaurante.exceptions;

import br.com.restaurante.model.Entree;

public class MenuValidation {

    public static void validarEntree(Entree prato) throws MenuInvalidoException {
        if (prato.getCalories() > 1000) {
            throw new MenuInvalidoException("❌ Prato excede o limite de 1000 calorias.");
        }

        if (prato.getName() == null || prato.getName().isBlank()) {
            throw new MenuInvalidoException("❌ Nome do prato não pode ser vazio.");
        }

        // Adicione mais regras aqui, se quiser
    }
}
