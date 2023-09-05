package br.com.fiap.fintech;

public class ContaNormal extends Conta {
    private double saldoConta;
    private String extratoConta;

    public ContaNormal(int idUser, String password, String email, String nome, String numeroConta, String tipoConta) {
        super(idUser, password, email, nome, numeroConta, tipoConta);
        this.saldoConta = 0.0;
        this.extratoConta = "";
    }

    public void transferirParaContaInvestimento(ContaInvestimento contaInvestimento, double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            retirarSaldo(valor);

            // Adiciona o valor à conta de investimento
            contaInvestimento.adicionarSaldo(valor);

            System.out.println("Transferência de R$ " + valor + " para a Conta de Investimento realizada com sucesso.");
        } else {
            System.out.println("Transferência inválida. Verifique o saldo da Conta Normal.");
        }
    }

    public void abrirConta() {
        System.out.println("Conta Normal aberta para o usuário: " + getNome());
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public String getExtratoConta() {
        return extratoConta;
    }

    public void setExtratoConta(String extratoConta) {
        this.extratoConta = extratoConta;
    }

}
