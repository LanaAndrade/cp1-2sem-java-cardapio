package br.com.fiap.integration;

import java.sql.*;

public class CreateMenu extends MenuDAO {

    @Override
    public void executeOperation(Connection conn, String nome, String descricao, double preco, String categoria,
            boolean disponivel, int tempoPreparoMin, int calorias,
            boolean vegano, boolean glutenFree) throws SQLException {
    	
    	/**
         * Método para inserir um item no cardápio.
         * @param conn Conexão com o banco de dados
         * @param nome Nome do prato ou bebida
         * @param descricao Descrição detalhada
         * @param preco Preço do item
         * @param categoria Ex: Entrada, Prato Principal, Bebida, Sobremesa
         * @param disponivel Disponível ou não
         * @param tempoPreparoMin Tempo de preparo estimado em minutos
         * @param calorias Quantidade de calorias
         * @param vegano Se é vegano
         * @param glutenFree Se é sem glúten
         */
    	
    	PreparedStatement stmt = null;

            String sql = "INSERT INTO cardapio (nome, descricao, preco, categoria, disponivel, "
                       + "tempo_preparo_min, calorias, vegano, gluten_free) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setDouble(3, preco);
                stmt.setString(4, categoria);
                stmt.setBoolean(5, disponivel);
                stmt.setInt(6, tempoPreparoMin);
                stmt.setInt(7, calorias);
                stmt.setBoolean(8, vegano);
                stmt.setBoolean(9, glutenFree);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("✅ Item inserido com sucesso!");
                }

            } catch (SQLException e) {
                System.err.println("❌ Erro ao inserir item no cardápio: " + e.getMessage());
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException e) {
                    System.err.println("⚠️ Erro ao fechar o PreparedStatement: " + e.getMessage());
                }
            }
    }
}


