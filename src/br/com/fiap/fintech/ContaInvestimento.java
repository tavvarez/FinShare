package br.com.fiap.fintech;

public class ContaInvestimento extends Conta {
    private double rendimentosConta;
    private String extratoInvestimento;

    public ContaInvestimento(int idConta, int idUser, String password, String email, String nome, String sobrenome, String numeroConta, String tipoConta) {
        super(idConta, idUser, password, email, nome, sobrenome, numeroConta, tipoConta);
        this.rendimentosConta = 0.0;
        this.extratoInvestimento = "";
    }

    public void aplicarInvestimento() {
        System.out.println("Investimento aplicado para o usuário: " + getNome());
    }

    

    public double getRendimentosConta() {
        return rendimentosConta;
    }

    public void setRendimentosConta(double rendimentosConta) {
        this.rendimentosConta = rendimentosConta;
    }

    public String getExtratoInvestimento() {
        return extratoInvestimento;
    }

    public void setExtratoInvestimento(String extratoInvestimento) {
        this.extratoInvestimento = extratoInvestimento;
    }

    
}
