package br.com.fiap.fintech;


public class App {
	
	public static void main(String[] args) {
		
		Conta novaConta = new Conta(1, "xxx", "xdxd@null", "Gabriel", "Tavares", "123456", "Corrente");

		novaConta.exibeFichaUsuario();
		novaConta.adicionarSaldo(500);
		novaConta.consultarSaldo();
		System.out.println();

		System.out.println("********************************");

		ContaNormal contaNormal = new ContaNormal(1, "xxx", "xdxd@null", "Gabriel", "Tavares", "123456", "Corrente");
		ContaInvestimento contaInvestimento = new ContaInvestimento(2, "yyy", "xdxd@null", "Gabriel", "Tavares", "789012", "Investimento");

		contaNormal.abrirConta();
		contaInvestimento.aplicarInvestimento();
		System.out.println();
		contaInvestimento.adicionarSaldo(500.9);
		contaInvestimento.consultarSaldo();

		System.out.println("********************************");

		PessoaFisica pessoaFisica = new PessoaFisica(2, "xxx", "xdxd@null", "Gabriel", "Tavares", "123.456.789-00", "123456", "Endereço 1", "50/50/1990");
		PessoaJuridica pessoaJuridica = new PessoaJuridica(3, "yyy", "xdxd@null", "Empresa", "Razão Social", "xxxxx", "Endereço 2");

		pessoaFisica.createUser();
		pessoaJuridica.createUser();
		pessoaFisica.exibeFichaUsuario();
		pessoaJuridica.exibeFichaUsuario();

		System.out.println("********************************");

		ContaNormal contaNormal1 = new ContaNormal(1, "xxx", "xdxd@null", "Gabriel", "Tavares", "123456", "Corrente");
		ContaInvestimento contaInvestimento2 = new ContaInvestimento(2, "yyy", "xdxd@null", "Gabriel", "Tavares", "789012", "Investimento");

		contaNormal1.adicionarSaldo(1000);
		contaNormal1.transferirParaContaInvestimento(contaInvestimento, 500);
		contaInvestimento2.getSaldo();

		System.out.println("********************************");

		Movimentacao movimentacao = new Movimentacao("transferência para conta investimento");
		movimentacao.registrarMovimentacao();
	}

}
