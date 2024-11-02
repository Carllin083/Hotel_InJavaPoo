package Gerenciadores;

import java.util.ArrayList;

import SistemaMain.Quarto;
import SistemaMain.TipoQuarto;

public class GerenciadorQuarto {
	private ArrayList<Quarto> listaQuartos = new ArrayList<>();

	public void cadastrarQuarto(int numeroQuarto, TipoQuarto tipo, int capacidade, int valorDiaria) {
		Quarto novoQuarto = new Quarto(numeroQuarto, tipo, capacidade, valorDiaria);
		listaQuartos.add(novoQuarto);
		System.out.println("Quarto cadastrado com sucesso: " + novoQuarto.getNumeroQuarto());
	}

	public Quarto buscarQuarto(int numeroQuarto) {
		for (Quarto quarto : listaQuartos) {
			if (quarto.getNumeroQuarto() == numeroQuarto) {
				return quarto;
			}
		}
		return null;
	}

	public ArrayList<Quarto> listarQuartosDisponiveis() {
		ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
		for (Quarto quarto : listaQuartos) {
			if (quarto.isDisponivel()) {
				quartosDisponiveis.add(quarto);
			}
		}
		return quartosDisponiveis;
	}

	public void atualizarStatusQuarto(int numeroQuarto, boolean disponivel) {
		Quarto quarto = buscarQuarto(numeroQuarto);
		if (quarto != null) {
			quarto.setDisponivel(disponivel);
			System.out.println("Status do quarto atualizado: " + (disponivel ? "Disponível" : "Ocupado"));
		} else {
			System.out.println("Erro: Quarto não encontrado - " + numeroQuarto);
		}
	}

	public ArrayList<Quarto> getListaQuartos() {
		return listaQuartos;
	}

	public void setListaQuartos(ArrayList<Quarto> listaQuartos) {
		this.listaQuartos = listaQuartos;
	}

}
