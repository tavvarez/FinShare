package br.com.fiap.fintech;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Movimentacao {
    private String tipoMovimentacao;
    private LocalDateTime dataHoraMovimentacao;

    public Movimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHoraMovimentacao = LocalDateTime.now();
    }

    public void registrarMovimentacao() {
        System.out.println("Movimentação registrada: " + tipoMovimentacao);
        System.out.println("Data e Hora: " + formatarDataHora(dataHoraMovimentacao));
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    private String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter);
    }
}
