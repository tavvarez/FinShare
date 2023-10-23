package br.com.fiap.fintech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteBancoDeDados {

	public static void main(String[] args) throws Exception {

		try {
			// define o driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Interface JDBC cuja implementação DriveManager abre uma conexão com a URL
			// definida para acesso ao banco
			Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM97958", "050298");

			System.out.println("Conectado com sucesso!");
			
//			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_USUARIO(ID_USUARIO, DS_NOME, DS_SOBRENOME, DS_EMAIL, DS_SENHA, DT_CADASTRO) VALUES (SQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)");
//			stmt.setString(1, "GABRIEL");       // Primeiro parâmetro (DS_NOME)
//			stmt.setString(2, "TAVARES");    // Segundo parâmetro (DS_SOBRENOME)
//			stmt.setString(3, "GABRIELTAVVAREZ@gmail.com"); // Terceiro parâmetro (DS_EMAIL)
//			stmt.setString(4, "11325852");        // Quarto parâmetro (DS_SENHA)
//			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
//			stmt.setDate(5, data);               // Quinto parâmetro (DT_CADASTRO)
//
//			stmt.executeUpdate();
			
			
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE DS_NOME = ?");
			stmt.setString(1, "Novo Nome");
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				int codigo = result.getInt("ID_USUARIO");
				String nome = result.getString("DS_NOME");
				String email = result.getString("DS_EMAIL");
				java.sql.Date data = result.getDate("DT_CADASTRO");
				
				System.out.println(codigo + " " + nome + " " + email + " " + data);
			}
			
			



			// Fecha conexão
			conexao.close();

		} catch (SQLException e) {
			System.err.println("Erro ao conectar o banco de dados!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("O driver do DB não foi encontrado!");
			e.printStackTrace();
		}

	}
}
