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

     public Movimentacao(double d, Object object, int i) {
		
	}
     
     public Movimentacao(double valor, Conta conta, int idConta) {
    	    this.valor = valor;
//    	    this.conta = conta;
    	    this.idConta = idConta;
    	}
     
     public Movimentacao(double valor, int idConta) {
    	 
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

    
    public int getIdConta() {
		return idConta;
	}
    
}
