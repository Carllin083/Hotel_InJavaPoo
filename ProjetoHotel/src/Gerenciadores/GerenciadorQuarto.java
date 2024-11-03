package Gerenciadores;

import java.util.ArrayList;

import SistemaMain.Quarto;
import SistemaMain.tipoQuarto;

public class GerenciadorQuarto {
	
	private ArrayList<Quarto> listaQuartos = new ArrayList<>();
	public Quarto[] get;

	public void cadastrarQuarto(int numeroQuarto, tipoQuarto tipo, int capacidade, int valorDiaria,
			boolean estaDisponivel) {
		boolean quartoEncontrado = false;
		for (Quarto quartoAtual : listaQuartos) {
			if (quartoAtual.getNumeroQuarto() == numeroQuarto) {
				System.out.println("já existe um quarto existente");
				quartoEncontrado = true;
			} else {
				Quarto quartoNovo = new Quarto(numeroQuarto, tipo, capacidade, valorDiaria);
				listaQuartos.add(quartoNovo);
				System.out.println("Novo quarto cadastrado com sucesso!!");
				atualizarStatusQuarto(numeroQuarto, estaDisponivel);
			}
		}

	}

	public void atualizarStatusQuarto(int numeroQuarto, boolean estaDisponivel) {
		for (Quarto quartoAtual : listaQuartos) {
			boolean quartoEncontrado = false;
			if (quartoAtual.getNumeroQuarto() == numeroQuarto) {
				quartoAtual.setEstaDisponivel(estaDisponivel);
				quartoEncontrado = true;
				System.out.println("Quarto atualizado com sucesso!!");
				System.out.println(String.format(
						"Status do Quarto:\nNúmero: %d\nTipo: %s\nCapacidade: %d pessoas\nValor da Diária: R$ %.2f\nDisponível: %s",
						quartoAtual.getNumeroQuarto(), quartoAtual.getTipo(), quartoAtual.getCapacidade(),
						quartoAtual.getValorDiaria(), estaDisponivel ? "Sim" : "Não"));
				break;
			} else {
				System.out.println("-=-=-=-=-=-=\nAtenção!!!\n=-=-=-=-=-=-=-\n\n Quarto de numero "
						+ quartoAtual.getNumeroQuarto() + "se encontra indisponivel!!");

			}
		}
	}

	public void visualizarQuartoDisponivel() {
		System.out.println("=-=-=-=-=-=-=-=-=-=\n\n");
		System.out.println("QUARTOS DISPONIVEIS");
		System.out.println("\n\n=-=-=-=-=-=-=-=-=-=\n\n");

		if (listaQuartos == null || listaQuartos.size() == 0) {
			System.out.println("Não existe quartos disponiveis ou cadastrados");
		}

		System.out.println("=-=-=-=-=-=-=-=-=-=\n\n");
		System.out.println("QUARTOS DISPONIVEIS");
		System.out.println("\n\n=-=-=-=-=-=-=-=-=-=\n\n");
		boolean quartoDisponivel = false;
		for (Quarto quartoAtual : listaQuartos) {
			if (quartoAtual.isEstaDisponivel()) {
				System.out.println("Numero do quarto: " + quartoAtual.getNumeroQuarto() + "Capcidade de pessoas: "
						+ quartoAtual.getCapacidade());
				quartoDisponivel = true;

			}
		}
	}

	// BUSCAR QUARTO PELO NUMERO
	public Quarto buscarQuarto(int numeroQuarto) {
		for (Quarto quartoAtual : listaQuartos) {
			if (quartoAtual.getNumeroQuarto() == numeroQuarto) {
				System.out.println("Quarto encontrado com sucesso: " + "\n Numero do quarto: "
						+ quartoAtual.getNumeroQuarto() + "\nTipo de Quarto" + quartoAtual.getTipo());
			}
		}
		return null;
	}
	
	public ArrayList<Quarto> getListaQuartos() {
	    return listaQuartos;
	}


}