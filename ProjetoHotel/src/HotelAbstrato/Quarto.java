package HotelAbstrato;

public class Quarto {
	// criação dos atributos juntamente com o construtor contendo parametros
	private int numeroDoQuarto;
	private String tipoQuarto;
	private String capacidadeMax;
	private int valorDiaria;
	private boolean disponibilidade;

	public Quarto(int numeroDoQuarto, String tipoQuarto, String capacidadeMax, int valorDiaria, boolean disponibilidade) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.tipoQuarto = tipoQuarto;
		this.capacidadeMax = capacidadeMax;
		this.valorDiaria = valorDiaria;
		this.disponibilidade = disponibilidade;
	}

	// Getters and Setters and toString
	public int getQuantidadeDeQuartos() {
		return numeroDoQuarto;
	}

	public void setQuantidadeDeQuartos(int numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public String getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(String capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}

	public int getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(int valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	// Room Information
	public String toString() {
		return "\n=-=-=-=-=-=-=-=-=-=-=-\n INFORMAÇÕES DO QUARTOS\nNumero do Quarto: " + numeroDoQuarto
				+ "\n Tipo do Quarto: " + tipoQuarto + "\nCapacidade maxima: " + capacidadeMax + "\n Valor da Diaria: " + valorDiaria + "\nDisponivel ? " + disponibilidade;
	}

}
