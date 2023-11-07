package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.fiap.fintech.Movimentacao;



public class MovimentacaoDAO {
	private Connection conexao;

    
	
	public MovimentacaoDAO() {
		
   }


	public void movimentacaoConta(Movimentacao movimentacao) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			conexao = FinShareDBManager.realizarConexao();
			String sql = "INSERT INTO T_TRANSACOES(ID_TRANSACAO, VL_VALOR_TRANSACAO, DT_DATA_HORA_TRANSACAO, T_CONTAS_ID_CONTA) "
					+ " VALUES (SEQ_ID_TRANSACAO.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, movimentacao.getValor()); // Segundo parâmetro (NR_CONTA)
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setDate(2, data); //Segundo parâmetro (DT_DATA_HORA_TRANSACAO)
			stmt.setInt(3, movimentacao.getIdConta()); // Terceiro parâmetro (T_CONTAS_ID_CONTAS)
			
			
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
	
	public void Usuario() {
		
	}
	
	public void despesaConta(Movimentacao movimentacao) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			conexao = FinShareDBManager.realizarConexao();
			String sql = "INSERT INTO T_DESPESAS(ID_DESPESA, VL_DESPESA, DT_DATA_HORA_DESPESA, T_USUARIO_ID_USUARIO) "
					+ " VALUES (SEQ_ID_DESPESA.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, movimentacao.getValor()); // Segundo parâmetro (VL_DESPESA)
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setDate(2, data); //Segundo parâmetro (DT_DATA_HORA_DESPESA)
			stmt.setInt(3, movimentacao.getIdUser()); // Terceiro parâmetro (T_USUARIO_ID_USUARIO)
			
			
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
	
	public void delDespesaConta(Movimentacao movimentacao) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			conexao = FinShareDBManager.realizarConexao();
			String sql = "DELETE FROM T_DESPESAS WHERE ID_DESPESA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, movimentacao.getIdUser()); // Primeiro parâmetro (T_USUARIO_ID_USUARIO)
			
			
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
	
}
