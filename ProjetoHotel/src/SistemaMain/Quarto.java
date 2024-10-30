package SistemaMain;

public class Quarto {
	int numeroQuarto;
	int tipo;
	int capacidade;
	boolean estaDisponivel;
	
	public Quarto(int numeroQuarto, int tipo, int capacidade) {
		this.numeroQuarto = numeroQuarto;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.estaDisponivel = true;//ao criar um quarto, ele ja cria como disponivel
	}
	
	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	
	
}
