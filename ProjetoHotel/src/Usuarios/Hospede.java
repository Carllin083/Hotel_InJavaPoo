package Usuarios;

public class Hospede extends Pessoa{
	public String dataNascimento;
	public String endereco;
	public String numero;
	public String[][][] historico;
	
	public Hospede(String nome, String cpf, String dataNascimento, String endereco, String numero, String[][][] historico) {
		super(nome, cpf, "Hospede");
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.numero = numero;
		this.historico = historico;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String[][][] getHistorico() {
		return historico;
	}

	public void setHistorico(String[][][] historico) {
		this.historico = historico;
	}
	

}
