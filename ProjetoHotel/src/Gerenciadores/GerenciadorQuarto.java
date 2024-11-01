package Gerenciadores;

import java.util.ArrayList;

import SistemaMain.Quarto;

public class GerenciadorQuarto {
	private ArrayList<Quarto> listaQuartos = new ArrayList<>();

	public void cadastrarQuarto(int numeroQuarto, int tipo, int capacidade, int valorDiaria) {
		Quarto novoQuarto = new Quarto(numeroQuarto, tipo, capacidade, valorDiaria);
		listaQuartos.add(novoQuarto);
	}

	public void atualizarStatusQuarto() {
	}

}