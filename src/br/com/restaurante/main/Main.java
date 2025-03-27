package br.com.restaurante.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.restaurante.exceptions.MenuInvalidoException;
import br.com.restaurante.exceptions.MenuValidation;
import br.com.restaurante.integration.CreateMenu;
import br.com.restaurante.integration.EntreeDAO;
import br.com.restaurante.integration.MainCourseDAO;
import br.com.restaurante.integration.MenuDAO;
import br.com.restaurante.integration.SelectMainCourse;
import br.com.restaurante.model.Entree;
import br.com.restaurante.model.MainCourse;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = MenuDAO.getConnection();
            System.out.println("🔌 Conectado ao banco!");

            // --- Inserção no cardápio (CreateMenu) ---
            CreateMenu createMenu = new CreateMenu();
            createMenu.executeOperation(conn,
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
            System.out.println("✅ Item 'Lasanha Vegana' inserido no cardápio!");

            // --- Inserção de MainCourse ---
            Set<String> dietaryPreferences = new HashSet<>();
            dietaryPreferences.add("Keto");
            dietaryPreferences.add("Low-Carb");
            dietaryPreferences.add("High-Protein");

            MainCourse pratoPrincipal = new MainCourse(
                    "Frango Grelhado",
                    "Peito de frango com legumes",
                    29.90,
                    true,
                    450,
                    false,
                    true,
                    "Grelhado",
                    "Médio",
                    "Na grelha",
                    dietaryPreferences,
                    true,
                    "Local",
                    true,
                    false
            );

            MainCourseDAO mainCourseDao = new MainCourseDAO();
            mainCourseDao.insert(conn, pratoPrincipal);
            System.out.println("✅ Prato principal 'Frango Grelhado' inserido com sucesso!");

            // --- Inserção de Entree (Lasanha de Berinjela) ---
            Entree lasanha = new Entree(
                    "Lasanha de Berinjela",
                    "Lasanha feita com massa de berinjela e molho de tomate",
                    34.90,
                    true,
                    800,
                    false,
                    true,
                    "Vegetariano",
                    "Porção única",
                    "Berinjela, molho de tomate, queijo mussarela",
                    "Assada"
            );

            MenuValidation.validarEntree(lasanha);
            EntreeDAO entreeDao = new EntreeDAO();
            entreeDao.insert(conn, lasanha);
            System.out.println("✅ Entrada 'Lasanha de Berinjela' inserida com sucesso!");

            // --- Inserção de Entree (Salada com molho de mostarda e mel) ---
            Entree salada = new Entree(
                    "Salada com Molho de Mostarda e Mel",
                    "Mix de folhas verdes com molho especial de mostarda e mel",
                    22.50,
                    true,
                    180,
                    false,
                    true,
                    "Salada",
                    "Porção individual",
                    "Alface, rúcula, molho de mostarda e mel, tomate-cereja",
                    "Fria"
            );

            MenuValidation.validarEntree(salada);
            entreeDao.insert(conn, salada);
            System.out.println("✅ Entrada 'Salada com Molho de Mostarda e Mel' inserida com sucesso!");

            // Commit se necessário
            if (!conn.getAutoCommit()) {
                conn.commit();
                System.out.println("📝 Commit executado.");
            }

            // --- Consulta de MainCourse por ID ---
            try {
                SelectMainCourse selectMainCourse = new SelectMainCourse(conn);
                int idParaBuscar = 1;

                MainCourse encontrado = selectMainCourse.findById(idParaBuscar);
                if (encontrado != null) {
                    System.out.println("🍽️ MainCourse encontrado:");
                    System.out.println("Nome: " + encontrado.getName());
                    System.out.println("Descrição: " + encontrado.getDescription());
                    System.out.println("Preço: R$" + encontrado.getPrice());
                    System.out.println("Disponível: " + (encontrado.isAvailable() ? "Sim" : "Não"));
                    System.out.println("Calorias: " + encontrado.getCalories());
                    System.out.println("Vegano: " + (encontrado.isVegan() ? "Sim" : "Não"));
                    System.out.println("Sem glúten: " + (encontrado.isGlutenFree() ? "Sim" : "Não"));
                    System.out.println("Tipo: " + encontrado.getMainCourseType());
                    System.out.println("Método de preparo: " + encontrado.getCookingMethod());
                    System.out.println("Nível de tempero: " + encontrado.getSpiceLevel());
                    System.out.println("Preferências alimentares: " + String.join(", ", encontrado.getDietaryPreferences()));
                    System.out.println("Orgânico: " + (encontrado.isOrganic() ? "Sim" : "Não"));
                    System.out.println("Fonte: " + encontrado.getSource());
                    System.out.println("Halal: " + (encontrado.isHalal() ? "Sim" : "Não"));
                    System.out.println("Kosher: " + (encontrado.isKosher() ? "Sim" : "Não"));
                } else {
                    System.out.println("⚠️ Nenhum prato encontrado com ID " + idParaBuscar);
                }

            } catch (SQLException e) {
                System.err.println("❌ Erro ao buscar prato por ID: " + e.getMessage());
            }

        } catch (MenuInvalidoException e) {
            System.err.println("❌ Menu inválido: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Erro de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Erro inesperado: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                System.out.println("🔒 Conexão encerrada.");
            } catch (SQLException e) {
                System.err.println("⚠️ Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
