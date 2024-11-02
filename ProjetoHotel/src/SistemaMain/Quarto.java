package SistemaMain;

public class Quarto {
	private int numeroQuarto;
	private TipoQuarto tipo;
	private int capacidade;
	private boolean estaDisponivel;
	private int valorDiaria;

	public Quarto(int numeroQuarto, TipoQuarto tipo, int capacidade, int valorDiaria) {
		this.numeroQuarto = numeroQuarto;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.valorDiaria = valorDiaria;
		this.estaDisponivel = true; // Quarto criado como disponível por padrão
	}

	// Getters e Setters
	public int getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(int valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isDisponivel() {
		return estaDisponivel;
	}

	public void setDisponivel(boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}

	public double getPrecoPorDia() {
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
