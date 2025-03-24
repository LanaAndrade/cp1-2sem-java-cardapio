package br.com.fiap.integration;

import br.com.fiap.model.MainCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainCourseDAO {

    public void insert(Connection conn, MainCourse prato) throws SQLException {
        // Definindo a consulta SQL para inserir o prato no banco de dados
        String sql = "INSERT INTO main_course (name, description, price, available, calories, vegan, gluten_free, main_course_type, spice_level, cooking_method, dietary_preferences, organic, source, halal, kosher) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Setando os parâmetros do PreparedStatement
            stmt.setString(1, prato.getName());
            stmt.setString(2, prato.getDescription());
            stmt.setDouble(3, prato.getPrice());
            stmt.setBoolean(4, prato.isAvailable());
            stmt.setInt(5, prato.getCalories());
            stmt.setBoolean(6, prato.isVegan());
            stmt.setBoolean(7, prato.isGlutenFree());
            stmt.setString(8, prato.getMainCourseType());
            stmt.setString(9, prato.getSpiceLevel());
            stmt.setString(10, prato.getCookingMethod());
            stmt.setString(11, String.join(",", prato.getDietaryPreferences()));  // Convertendo o Set para uma String
            stmt.setBoolean(12, prato.isOrganic());
            stmt.setString(13, prato.getSource());
            stmt.setBoolean(14, prato.isHalal());
            stmt.setBoolean(15, prato.isKosher());

            // Executando a inserção no banco de dados
            stmt.executeUpdate();
        }
    }
}
