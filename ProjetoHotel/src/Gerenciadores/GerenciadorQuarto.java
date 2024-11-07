package Gerenciadores;

import java.util.ArrayList;

import SistemaMain.Quarto;
import SistemaMain.tipoQuarto;

public class GerenciadorQuarto {
	private ArrayList<Quarto> listaQuartos = new ArrayList<>();

	public void cadastrarQuarto(int numeroQuarto, tipoQuarto tipo, int capacidade, double valorDiaria1) {
		Quarto novoQuarto = new Quarto(numeroQuarto, tipo, capacidade, valorDiaria1);
		listaQuartos.add(novoQuarto);
		System.out.println("Quarto cadastrado com sucesso: " + novoQuarto.getNumeroQuarto());
	}

	public Quarto buscarQuarto(int numeroQuarto) {
		for (Quarto quartoAtual : listaQuartos) {
			if (quartoAtual.getNumeroQuarto() == numeroQuarto) {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("Quarto encontrato com sucesso!!\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" + "\nNumero do Quarto: "
						+ quartoAtual.getNumeroQuarto() + "\nTipo de Quarto: " + quartoAtual.getTipo() + "\nCapacidade: " + quartoAtual.getCapacidade() );
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				return quartoAtual;
			}
		}
		return null;
	}

	public ArrayList<Quarto> listarQuartosDisponiveis() {
		ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
		for (Quarto quarto : listaQuartos) {
			if (quarto.EstaDisponivel()) {
				quartosDisponiveis.add(quarto);
			}
		}
		return quartosDisponiveis;
	}

	public void atualizarStatusQuarto(int numeroQuarto, boolean disponivel) {
		Quarto quarto = buscarQuarto(numeroQuarto);
		if (quarto != null) {
			quarto.setEstaDisponivel(disponivel);
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