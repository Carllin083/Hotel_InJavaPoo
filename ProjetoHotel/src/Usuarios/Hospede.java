package Usuarios;

public class Hospede extends Pessoa {
	private String dataNascimento;
	private String endereco;
	private String[][][] historico;
	private String contato;

	public Hospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
		super(nome, cpf, "Hospede");
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.contato = contato;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String[][][] getHistorico() {
		return historico;
	}

	public void setHistorico(String[][][] historico) {
		this.historico = historico;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
