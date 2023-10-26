package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FinShareDBManager {

	public static Connection realizarConexao() throws SQLException {

		Connection conexao = null;

		try {
			// define o driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Interface JDBC cuja implementação DriveManager abre uma conexão com a URL
			// definida para acesso ao banco
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM97958",
					"050298");

			// Exceção de driver não encontrado
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver Oracle JDBC não encontrado", e);
			// Exceção de SQL
		} catch (SQLException e) {
			if (e.getErrorCode() == 1017) {
				throw new SQLException("Senha incorreta!", e);
			}

		} catch (Exception e) {
			System.err.println("Erro ao conectar o banco de dados!");
			e.printStackTrace();
		}
		return conexao;
	}
}
