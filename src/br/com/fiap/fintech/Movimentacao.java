package br.com.fiap.fintech;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa uma movimentação financeira.
 */
public class Movimentacao {
    private String tipoMovimentacao;
    private LocalDateTime dataHoraMovimentacao;

    /**
     * Cria uma nova instância de Movimentacao com o tipo especificado.
     *
     * @param tipoMovimentacao O tipo de movimentação, como "transferência para conta investimento".
     */
    public Movimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHoraMovimentacao = LocalDateTime.now();
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

    private String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter);
    }
}
