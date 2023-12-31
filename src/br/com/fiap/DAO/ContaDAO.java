package br.com.fiap.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.Conta;

public class ContaDAO {
	private Connection conexao;

    
	
	public ContaDAO() {
		
   }


	public void adicionarContaUsuario(Conta conta) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			conexao = FinShareDBManager.realizarConexao();
			String sql = "INSERT INTO T_CONTAS(ID_CONTA, NR_CONTA, DS_CONTA, VL_SALDO_ATUAL, T_USUARIO_ID_USUARIO) "
					+ " VALUES (SEQ_ID_CONTA.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, conta.getNumeroConta()); // Segundo parâmetro (NR_CONTA)
			stmt.setString(2, conta.getTipoConta()); // Terceiro parâmetro (DS_CONTA)
			stmt.setDouble(3, conta.getSaldo()); // Quarto parâmetro (VL_SALDO)
			stmt.setInt(4, conta.getIdUser()); // Quinto parâmetro (ID_USER)
			
			
			stmt.execute();
			
			conexao.commit(); // Confirma as alterações
			
		} catch (SQLException e) {
			// dar rollback em caso de exceção
			conexao.rollback();
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	public List<ContaDAO> getAll() {
//		// Cria uma lista de contas
//		List<ContaDAO> lista = new ArrayList<ContaDAO>();
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			conexao = FinShareDBManager.realizarConexao();
//			stmt = conexao.prepareStatement("SELECT * FROM T_CONTAS");
//			rs = stmt.executeQuery();
//
//			// Percorre todos os registros encontrados
//			while (rs.next()) {
//				int idConta = rs.getInt("ID_CONTA");
//				String numeroConta = rs.getString("NR_CONTA");
//				String tipoConta = rs.getString("DS_CONTA");
//				double saldo = rs.getDouble("VL_SALDO_ATUAL");
//				int idUser = rs.getInt("T_USUARIO_ID_USUARIO");
//				// Cria um objeto novoUsuario com as informações encontradas
//				ContaDAO novaConta = new ContaDAO(idConta, idUser, numeroConta, tipoConta, saldo);
//				// Adiciona o colaborador na lista
//				lista.add(novaConta);
//			}
//		} catch (SQLException e) {
//			if (e.getErrorCode() == 942) {
//				System.out.printf("Tabela inexistente!", e);
//			}
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//				rs.close();
//				conexao.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return lista;
//	}

	
}
