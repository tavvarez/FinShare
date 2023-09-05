package br.com.fiap.fintech;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma conta bancária.
 */
public class Conta extends Usuario {

	private String numeroConta;
    private String tipoConta;

	public Conta(int idUser, String password, String email, String nome, String numeroConta, String tipoConta) {
        super(idUser, password, email, nome);
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
    }

	private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

	public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public void createUser() {
        System.out.println("Conta criada para o usuário: " + getNome());
    }

}
