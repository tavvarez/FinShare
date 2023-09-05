package br.com.fiap.fintech;

public class PessoaFisica extends Usuario {
    private String cpf;
    private String rg;
    private String endereco;
    private String dtNasc;

    @Override
    public void createUser() {
        System.out.println("Usuário Pessoa Física criado: " + getNome());
    }

    public PessoaFisica(int idUser, String password, String email, String nome, String cpf, String rg, String endereco, String dtNasc) {
        super(idUser, password, email, nome);
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.dtNasc = dtNasc;
    }

    // getters e setters
    public String getCpf() {
        return cpf;
    }

    // public void setCpf(String cpf) {
    //     this.cpf = cpf;
    // }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

}
