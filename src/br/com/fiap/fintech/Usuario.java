package br.com.fiap.fintech;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um usuário da fintech.
 */
public abstract class Usuario {
	private int idUser;
	private String password;
	private String email;
	private String nome;
    private Double saldo;


    // constructor
    public Usuario(int idUser, String password, String email, String nome) {
        this.idUser = idUser;
        this.password = password;
        this.email = email;
        this.nome = nome;
        this.saldo = 0.0;
    }

    private List<Conta> contas = new ArrayList<>();

    
    /** 
     * @param conta
     */
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        conta.adicionarUsuario(this);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
        conta.removerUsuario(this);
    }

     /**
     * Cria um novo usuário.
     */
    public abstract void createUser();

    public void changePassword(String newPassword) {
        this.password = newPassword;
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

    // getters e setters
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Double getSaldo() {
        return saldo;
    }

	/**
     * Exibe informações do usuário.
     */
	public void exibeFichaUsuario() {
		System.out.println("Nome: " + nome);
		System.out.println("Senha: " + password);
		System.out.println("E-mail: " + email);
		System.out.println("ID Usuario: " + idUser);

	}

}
