package br.com.fiap.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.fiap.model.Entree;

public class EntreeDAO {

    // Método para inserir um prato no banco de dados
    public void insert(Connection conn, Entree entree) throws SQLException {
        // SQL para inserir o prato no banco de dados
        String sql = "INSERT INTO entree (name, description, price, available, calories, vegan, glutenFree, entreeType, portionSize, mainIngredients, servingMethod) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Preparando o statement
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entree.getName());
            stmt.setString(2, entree.getDescription());
            stmt.setDouble(3, entree.getPrice());
            stmt.setBoolean(4, entree.isAvailable());
            stmt.setInt(5, entree.getCalories());
            stmt.setBoolean(6, entree.isVegan());
            stmt.setBoolean(7, entree.isGlutenFree());
            stmt.setString(8, entree.getEntreeType());
            stmt.setString(9, entree.getPortionSize());
            stmt.setString(10, entree.getMainIngredients());
            stmt.setString(11, entree.getServingMethod());

            // Executando a inserção
            stmt.executeUpdate();
        }
    }
}
