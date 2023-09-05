package br.com.fiap.fintech;

public class PessoaJuridica extends Usuario {
    private String cnpj;
    private String endereco;

    @Override
    public void createUser() {
        System.out.println("Usuário Pessoa Jurídica criado: " + getNome());
    }

    public PessoaJuridica(int idUser, String password, String email, String nome, String cnpj, String endereco) {
        super(idUser, password, email, nome);
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    //getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}