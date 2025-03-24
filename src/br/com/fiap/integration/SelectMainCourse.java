package br.com.fiap.integration;

import br.com.fiap.model.MainCourse;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SelectMainCourse {

    private Connection conn;

    // Construtor recebendo a conexão
    public SelectMainCourse(Connection conn) {
        this.conn = conn;
    }

    // Método para buscar um MainCourse por ID
    public MainCourse findById(int id) throws SQLException {
        String sql = "SELECT * FROM main_course WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Set<String> dietaryPreferences = new HashSet<>();
                    String prefs = rs.getString("dietary_preferences");
                    if (prefs != null && !prefs.isEmpty()) {
                        for (String pref : prefs.split(",")) {
                            dietaryPreferences.add(pref.trim());
                        }
                    }

                    return new MainCourse(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getBoolean("available"),
                        rs.getInt("calories"),
                        rs.getBoolean("vegan"),
                        rs.getBoolean("gluten_free"),
                        rs.getString("main_course_type"),
                        rs.getString("cooking_method"),
                        rs.getString("spice_level"),
                        dietaryPreferences,
                        rs.getBoolean("organic"),
                        rs.getString("source"),
                        rs.getBoolean("halal"),
                        rs.getBoolean("kosher")
                    );
                }
            }
        }
        return null; // Se não encontrar nenhum resultado
    }
}
