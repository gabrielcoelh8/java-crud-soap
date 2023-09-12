package br.edu.ifms.crudsoap.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final Connection connection = newConnection();
	
	private static Connection newConnection() {
		try {			
			Class.forName("org.postgresql.Driver");			
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5433/crud-soap", 
					"postgres",
					"postgres");

		} catch (Exception ex) {
			System.err.println("Conexão falhou: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	public static Connection getConnection() {
		return connection;
	}
}
