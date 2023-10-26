package br.com.fiap.fintech;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma conta bancária.
 */
public class Conta extends Usuario {

	private String numeroConta;
    private String tipoConta;

	public Conta(int idUser, String password, String email, String nome, String sobrenome, String numeroConta, String tipoConta) {
        super(idUser, password, email, nome, sobrenome);
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
    }

	private List<Usuario> usuarios = new ArrayList<>();

    
    /** 
     * @param usuario
     */
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    // getters e setters

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
