package HotelAbstrato;

public abstract class QuartoAbstrato {
	// criação dos atributos juntamente com o construtor contendo parametros
	private int numeroDoQuarto;
	private String tipoQuarto;
	private String capacidadeMax;
	private int valorDiaria;
	private boolean disponibilidade;

	public QuartoAbstrato(int numeroDoQuarto, String tipoQuarto, String capacidadeMax, int valorDiaria, boolean disponibilidade) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.tipoQuarto = tipoQuarto;
		this.capacidadeMax = capacidadeMax;
		this.valorDiaria = valorDiaria;
		this.disponibilidade = disponibilidade = true;
	}
	
	public abstract void detalhesDoQuarto();
	
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



}
