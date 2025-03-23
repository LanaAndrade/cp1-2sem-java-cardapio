package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.integration.CreateMenu;
import br.com.fiap.integration.MenuDAO;
import br.com.fiap.model.MenuItem;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Get connection from ConnectionDB class
            conn = MenuDAO.getConnection();

            // Create CardapioDAO object and insert item
            CreateMenu dao = new CreateMenu();
            dao.executeOperation(conn,
                    "Lasanha Vegana",
                    "Lasanha feita com massa integral e queijo vegano",
                    29.90,
                    "Prato Principal",
                    true,
                    30,
                    500,
                    true,
                    true
            );

        } catch (SQLException e) {
            System.err.println("❌ Erro na conexão: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("⚠️ Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    boolean valido = MenuItem.Validation.validatePrice(29.90);

}
