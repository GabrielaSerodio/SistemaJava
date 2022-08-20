package br.com.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoMySQL {

	public static void main(String[] args) {
				
		String servidor = "jdbc:mysql://localhost:3306/sistema_funcionarios?useTimezone=true&serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String senha = "Eita@123";
		
		Connection conexao;
		Statement instrucaoSQL;
		ResultSet resultados;

		try {
			conexao = DriverManager.getConnection(servidor, usuario, senha);
			
			instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			resultados = instrucaoSQL.executeQuery("SELECT * FROM funcionario"); 
		} catch (SQLException erro) {
			System.out.println(erro.getMessage());
		}
	}
} 
