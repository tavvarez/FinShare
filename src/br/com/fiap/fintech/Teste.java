package br.com.fiap.fintech;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.DAO.FinShareDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;




public class Teste {
	
	public static void main(String[] args) throws SQLException {

		// novoUser.setNome("Gabriel");
		// novoUser.setEmail("xdxd@null");
		// novoUser.setPassword("xxx");
		// novoUser.setIdUser(1);

//		Conta novaConta = new Conta(1, "xxx", "xdxd@null", "Gabriel", "123456", "Corrente");
//
//		novaConta.exibeFichaUsuario();
//		novaConta.adicionarSaldo(500);
//		novaConta.consultarSaldo();
//		System.out.println();
//
//		System.out.println("********************************");
//
//		ContaNormal contaNormal = new ContaNormal(1, "xxx", "xdxd@null", "Gabriel", "123456", "Corrente");
//		ContaInvestimento contaInvestimento = new ContaInvestimento(2, "yyy", "xdxd@null", "Gabriel", "789012", "Investimento");
//
//		contaNormal.abrirConta();
//		contaInvestimento.aplicarInvestimento();
//		System.out.println();
//		contaInvestimento.adicionarSaldo(500.9);
//		contaInvestimento.consultarSaldo();
//
//		System.out.println("********************************");
//
//		PessoaFisica pessoaFisica = new PessoaFisica(2, "xxx", "xdxd@null", "Gabriel", "123.456.789-00", "123456", "Endereço 1", "50/50/1990");
//		PessoaJuridica pessoaJuridica = new PessoaJuridica(3, "yyy", "xdxd@null", "Empresa", "xxxxx", "Endereço 2");
//
//		pessoaFisica.createUser();
//		pessoaJuridica.createUser();
//		pessoaFisica.exibeFichaUsuario();
//		pessoaJuridica.exibeFichaUsuario();
//
//		System.out.println("********************************");
//
//		ContaNormal contaNormal1 = new ContaNormal(1, "xxx", "xdxd@null", "Gabriel", "123456", "Corrente");
//		ContaInvestimento contaInvestimento2 = new ContaInvestimento(2, "yyy", "xdxd@null", "Gabriel", "789012", "Investimento");
//
//		contaNormal1.adicionarSaldo(1000);
//		contaNormal1.transferirParaContaInvestimento(contaInvestimento, 500);
//		contaInvestimento2.getSaldo();
//
//		System.out.println("********************************");
//
//		Movimentacao movimentacao = new Movimentacao("transferência para conta investimento");
//		movimentacao.registrarMovimentacao();

		
		System.out.println("********************************");
		System.out.println("CONEXÃO COM O BANCO DE DADOS");
		
		UsuarioDAO dao = new UsuarioDAO(0, null, null, null, null, null);
		
		PessoaFisica usuarioDB = new PessoaFisica(0, "123456", "gabrieldaraujotavares@gmail.com", "Gabriel", "Tavares", null, null, null, null);
		
		dao.cadastrarUsuarioDB(usuarioDB);
		System.out.println("Usuário cadastrado no DB");
		
		UsuarioDAO daoConsulta = new UsuarioDAO(0, null, null, null, null, null);
        List<UsuarioDAO> lista = daoConsulta.getAll();
        
        for (UsuarioDAO item : lista) {
            System.out.println(item.getIdUsuario() + " " + item.getNome() + " " + item.getSobrenome() + " " + item.getEmail() + " " + item.getSenha() + " " + item.getdataCadastro().getTime());
        }
		
	}
}
