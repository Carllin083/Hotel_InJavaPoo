package SistemaMain;

public class Quarto {
	
	private int numeroQuarto;
	private tipoQuarto tipo;
	private int capacidade;
	private boolean estaDisponivel;
	private int valorDiaria;

	public Quarto(int numeroQuarto, tipoQuarto tipo, int capacidade, int valorDiaria ) {
		this.numeroQuarto = numeroQuarto;
		this.capacidade = capacidade;
		this.valorDiaria = valorDiaria;
		this.estaDisponivel = true;// ao criar um quarto, ele ja cria como disponivel
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isEstaDisponivel() {
		return estaDisponivel;
	}

	public void setEstaDisponivel(boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}

	public int getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(int valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public tipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(tipoQuarto tipo) {
		this.tipo = tipo;
	}
	
	public double valorDiaria(tipoQuarto tipo) {
		switch (tipo) {
		case SOLTEIRO:
			return 100.0; // Preço para quarto solteiro
		case CASAL:
			return 150.0; // Preço para quarto casal
		case SUITE:
			return 250.0; // Preço para suíte
		default:
			return 0.0;
		}
	}

}
