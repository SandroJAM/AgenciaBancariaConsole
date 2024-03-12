package Programa;

public class Cliente {

	private static int counter = 1;

	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	// Constructor Using Fildes

	public Cliente(String nome, String cpf, String email, String telefone) {
		//super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		
		counter += 1;
		
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	// Metodo toString (Para Apresentar Dados);
	public String toString() {
		return "\nNome: " + this.getNome() + "\nCPF : " + this.getCpf() +
	           "\nEmail: " + this.getEmail() + "\nTelefone : " + this.getTelefone();
	}

}