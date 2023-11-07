package br.com.fiap.fintech;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa uma movimentação financeira.
 */
public class Movimentacao {
    private String tipoMovimentacao;
    private LocalDateTime dataHoraMovimentacao;
    private double valor;
//	private Conta conta;

    /**
     * Cria uma nova instância de Movimentacao com o tipo especificado.
     *
     * @param tipoMovimentacao O tipo de movimentação, como "transferência para conta investimento".
     * @param valor 
     */
    public Movimentacao(String tipoMovimentacao, double valor) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHoraMovimentacao = LocalDateTime.now();
        this.valor = valor;
    }

     public Movimentacao(double valor, Object object, int idUser) {
    	 this.valor = valor;
    	 this.idUser = idUser;
	}
     
     public Movimentacao(double valor, Conta conta, int idConta, int idUser) {
    	    this.valor = valor;
//    	    this.conta = conta;
    	    this.idConta = idConta;
    	    this.idUser = idUser;
    	}
     
     public Movimentacao(double valor, int idConta, int idUser) {
    	 
     }
     
     
     
	/**
     * Registra a movimentação.
     */
    public void registrarMovimentacao() {
        System.out.println("Movimentação registrada: " + tipoMovimentacao);
        System.out.println("Data e Hora: " + formatarDataHora(dataHoraMovimentacao));
    }

    /**
     * Obtém o tipo de movimentação.
     *
     * @return O tipo de movimentação.
     */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }
    
    public double getValor() {
    	return valor;
    }   
    
    
    public LocalDateTime getDataHoraMovimentacao(String formatarDataHora) {
		return dataHoraMovimentacao;
	}

	

	/** 
     * @param dataHora
     * @return String
     */
    private String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter);
    }
    
    Conta contaMovimentacao = new Conta(); // Cria uma instância de Conta
    int idConta = getIdConta();
    double saldo = getSaldo();
    int idUser = getIdUser();
    double valores = getValor();

    
    public int getIdConta() {
		return idConta;
	}
    
    public int getIdUser() {
		return idUser;
	}

	private double getSaldo() {
		return saldo;
	}

	public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void retirarSaldo(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Retirada de R$ " + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para retirada.");
        }
    }

    /**
     * Consulta o saldo da conta.
     */
    public void consultarSaldo() {
        System.out.println("\nSeu saldo atual é: " + saldo);
    }
    
}
