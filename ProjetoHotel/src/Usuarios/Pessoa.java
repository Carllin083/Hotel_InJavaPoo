package Usuarios;

public class Pessoa {
	private String nome;
	private String cpf;
	private String tipo;
	
	

	public Pessoa(String nome, String cpf, String tipo) {
		this.cpf = cpf;
		this.nome = nome;
		this.tipo = tipo;

	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
