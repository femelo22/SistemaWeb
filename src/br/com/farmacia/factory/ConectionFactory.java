package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

	private static final String URL = "jdbc:mysql://localhost/sistemaweb";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	//m�todo para fazer a conex�o com o nosso banco
	public static Connection getConection() throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
		return conexao;	
	}
	
	//chamando a nossa fun��o de conex�o
	public static void main(String[] args){
		
		try {
			Connection conexao = ConectionFactory.getConection();
			System.out.println("Conectado!");
			
		} catch (SQLException e) {
			System.out.println("Falha na conex�o: " + e);
		}
	}
	
	
}
