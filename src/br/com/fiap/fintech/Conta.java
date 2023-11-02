package br.com.fiap.fintech;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma conta bancária.
 */
public class Conta extends Usuario {

	private String numeroConta;
    private String tipoConta;
    private int idConta;
    private int idUser;
	private Double saldo;

	public Conta(int idConta, int idUser, String password, String email, String nome, String sobrenome, String numeroConta, String tipoConta, Double saldo) {
        super(idUser, password, email, nome, sobrenome);
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
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

    public int getIdConta() {
		return idConta;
	}
    
    public int getIdUser() {
		return idUser;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	@Override
    public void createUser() {
        System.out.println("Conta criada para o usuário: " + getNome());
    }

	public Double getSaldo() {
		return saldo;
	}

}
