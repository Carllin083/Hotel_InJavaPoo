package SistemaMain;

public class Quarto {
	private int numeroQuarto;
	private tipoQuarto tipo;
	private int capacidade;
	private boolean estaDisponivel;
	private double valorDiaria;

	public Quarto(int numeroQuarto, tipoQuarto tipo, int capacidade, double valorDiaria1) {
		this.numeroQuarto = numeroQuarto;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.valorDiaria = valorDiaria1;
		this.estaDisponivel = true;// ao criar um quarto, ele ja cria como disponivel
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public boolean isEstaDisponivel() {
		return estaDisponivel;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public tipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(tipoQuarto tipo) {
		this.tipo = tipo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean EstaDisponivel() {
		return estaDisponivel;
	}

	public void setEstaDisponivel(boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}

}
