package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.fintech.Usuario;


public class UsuarioDAO {

	private Connection conexao;
	private String email;
	private int idUsuario;
	private String nome;
	private Calendar dataCadastro;
	private String senha;


    public UsuarioDAO(int idUsuario, String nome, String email, String senha, Calendar dataCadastro) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

	public void cadastrarUsuarioDB(Usuario usuario) {
		PreparedStatement stmt = null;

		try {
			conexao = FinShareDBManager.realizarConexao();
			String sql = "INSERT INTO T_USUARIO(ID_USUARIO, DS_NOME, DS_SOBRENOME, DS_EMAIL, DS_SENHA, DT_CADASTRO) VALUES (SQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome()); // Primeiro parâmetro (DS_NOME)
			stmt.setString(2, "x"); // Segundo parâmetro (DS_SOBRENOME)
			stmt.setString(3, usuario.getEmail()); // Terceiro parâmetro (DS_EMAIL)
			stmt.setString(4, usuario.getPassword()); // Quarto parâmetro (DS_SENHA)
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setDate(5, data); // Quinto parâmetro (DT_CADASTRO)

			stmt.executeUpdate();
		} catch (SQLException e) {
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
	
	public List<UsuarioDAO> listar() {
	    //Cria uma lista de usuarios
	    List<UsuarioDAO> lista = new ArrayList<UsuarioDAO>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	      conexao = FinShareDBManager.realizarConexao();
	    stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
	    rs = stmt.executeQuery();
	  
	    //Percorre todos os registros encontrados
	    while (rs.next()) {
	    int idUsuario = rs.getInt("ID_USUARIO");
	    String nome = rs.getString("DS_NOME");
	        String email = rs.getString("DS_EMAIL");
	        String senha = rs.getString("DS_SENHA");
	        java.sql.Date data = rs.getDate("DT_CADASTRO");
	        Calendar dataCadastro = Calendar.getInstance();
	        dataCadastro.setTimeInMillis(data.getTime());
	        //Cria um objeto novoUsuario com as informações encontradas
	        UsuarioDAO novoUsuario = new UsuarioDAO(idUsuario, nome, email, senha, dataCadastro);
	        //Adiciona o colaborador na lista
	        lista.add(novoUsuario);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }finally {
	      try {
	        stmt.close();
	        rs.close();
	        conexao.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return lista;
	  }

	public int getIdUsuario() {
		// TODO Auto-generated method stub
		return idUsuario;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	public String getSenha() {
		// TODO Auto-generated method stub
		return senha;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public Calendar getdataCadastro() {
	    return dataCadastro;
	}
}

