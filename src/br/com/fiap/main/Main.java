package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.fiap.integration.CreateMenu;
import br.com.fiap.integration.MenuDAO;
import br.com.fiap.model.Entree;
import br.com.fiap.model.MainCourse;
import br.com.fiap.model.MenuItem;
import br.com.fiap.integration.MainCourseDAO;

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

            System.out.println("✅ Lasanha inserida com sucesso!");

            // --- COMPLEMENTO: Exemplo de criação de objeto e inserção via DAO ---
            // Criando o Set de dietaryPreferences
            Set<String> dietaryPreferences = new HashSet<>();
            dietaryPreferences.add("Keto");
            dietaryPreferences.add("Low-Carb");
            dietaryPreferences.add("High-Protein");

            // Criando o objeto MainCourse com todos os parâmetros
            MainCourse prato = new MainCourse(
                    "Frango Grelhado",                           // name
                    "Peito de frango com legumes",               // description
                    29.90,                                       // price
                    true,                                        // available
                    450,                                         // calories
                    false,                                       // vegan
                    true,                                        // glutenFree
                    "Grelhado",                                  // mainCourseType
                    "Médio",                                     // spiceLevel
                    "Na grelha",                                 // cookingMethod
                    dietaryPreferences,                          // dietaryPreferences
                    true,                                        // organic
                    "Local",                                     // source
                    true,                                        // halal
                    false                                        // kosher
            );

            // Inserindo o prato no banco de dados usando MainCourseDAO
            MainCourseDAO mainCourseDao = new MainCourseDAO();
            mainCourseDao.insert(conn, prato);

            System.out.println("✅ Prato 'Frango Grelhado' inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("❌ Erro na conexão: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("⚠️ Erro ao fechar conexão: " + e.getMessage());
            }
        }
            
            
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
	
	        System.out.println("✅ Lasanha inserida com sucesso!");
	
	        // --- COMPLEMENTO: Exemplo de criação de objeto e inserção via DAO --- 
	        // Criando o Set de dietaryPreferences
	        Set<String> dietaryPreferences = new HashSet<>();
	        dietaryPreferences.add("Keto");
	        dietaryPreferences.add("Low-Carb");
	        dietaryPreferences.add("High-Protein");
	
	        // Criando o objeto Entree com todos os parâmetros
	        Entree prato = new Entree(
	                "Lasanha de Berinjela",                      // name
	                "Lasanha feita com massa de berinjela e molho de tomate", // description
	                34.90,                                      // price
	                true,                                        // available
	                300,                                         // calories
	                false,                                       // vegan
	                true,                                        // glutenFree
	                "Vegetariano",                               // entreeType
	                "Porção única",                              // portionSize
	                "Berinjela, molho de tomate, queijo mussarela", // mainIngredients
	                "Assada"                                     // servingMethod
	        );
	
	        // Inserindo o prato no banco de dados usando EntreeDAO (caso tenha um DAO para essa classe)
	        //EntreeDAO entreeDao = new EntreeDAO();
	        //entreeDao.insert(conn, prato);
	
	        System.out.println("✅ Prato 'Lasanha de Berinjela' inserido com sucesso!");
	
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
}
