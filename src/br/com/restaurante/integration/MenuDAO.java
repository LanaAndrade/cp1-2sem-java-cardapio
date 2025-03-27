package br.com.restaurante.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MenuDAO {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "rm552596";
    private static final String PASSWORD = "020503";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException("Falha na conexão com o banco de dados", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

	public void executeOperation(Connection conn, String nome, String descricao, double preco, String categoria,
            boolean disponivel, int tempoPreparoMin, int calorias,
            boolean vegano, boolean glutenFree) throws SQLException {
		
	}
}
