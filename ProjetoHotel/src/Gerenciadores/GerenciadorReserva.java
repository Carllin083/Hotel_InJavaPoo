package Gerenciadores;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import SistemaMain.Quarto;
import SistemaMain.Reserva;
import Usuarios.Hospede;

public class GerenciadorReserva {

	private ArrayList<Reserva> listaReservas = new ArrayList<>();
	private GerenciadorHospede gerenciadorHospede;
	private GerenciadorQuarto gerenciadorQuarto;

	public GerenciadorReserva() {
	}

	public GerenciadorReserva(GerenciadorHospede gerenciadorHospede, GerenciadorQuarto gerenciadorQuarto) {
		this.gerenciadorHospede = gerenciadorHospede;
		this.gerenciadorQuarto = gerenciadorQuarto;
	}

	public void criarReserva(String cpf, int numeroQuarto, String dataEntrada, String dataSaida) {
		if (gerenciadorHospede == null || gerenciadorQuarto == null) {
			System.out.println("Erro: Dependências de hóspede ou quarto não configuradas.");
			return;
		}
		
		//BUSCAR HOSPEDE POR CPF
		Hospede hospede = gerenciadorHospede.buscarHospedePorCPF(cpf);
			if (hospede == null) {
				System.out.println("Erro: Hóspede não encontrado.");
		}
			
		//BUSCAR QUARTO PELO NUMERO
		Quarto quarto = gerenciadorQuarto.buscarQuarto(numeroQuarto);
		if (quarto == null || !quarto.isEstaDisponivel()) {
			System.out.println("Erro: Quarto não encontrado ou indisponível.");
			return;
		}

		LocalDate entrada = LocalDate.parse(dataEntrada);
		LocalDate saida = LocalDate.parse(dataSaida);

		if (!saida.isAfter(entrada)) {
			System.out.println("Erro: A data de saída deve ser posterior à data de entrada.");
			return;
		}

		int protocolo = gerarProtocoloUnico();
		if (protocolo == -1) {
			System.out.println("Erro: Não foi possível gerar um protocolo único.");
			return;
		}

		Reserva novaReserva = new Reserva(quarto, hospede, entrada, saida, protocolo);
		listaReservas.add(novaReserva);
		quarto.setEstaDisponivel(false);
		System.out.println("Reserva criada com sucesso para o quarto " + numeroQuarto);
	}

	public void checkOut(int numeroReserva) {
		Reserva reservaParaCheckOut = null;
		for (Reserva reserva : listaReservas) {
			if (reserva.getProtocoloReserva() == numeroReserva) {
				reservaParaCheckOut = reserva;
				break;
			}
		}
		if (reservaParaCheckOut == null) {
			System.out.println("Erro: Reserva não encontrada.");
			return;
		}

		Quarto quarto = reservaParaCheckOut.getQuarto();
		if (!quarto.isEstaDisponivel()) {
			LocalDate hoje = LocalDate.now();
			long dias = java.time.temporal.ChronoUnit.DAYS.between(reservaParaCheckOut.getDataEntrada(), hoje);
			double valorTotal = dias * quarto.getValorDiaria();

			quarto.setEstaDisponivel(true);;
			listaReservas.remove(reservaParaCheckOut);

			System.out.println(
					"Check-out concluído com sucesso. Valor total: " + valorTotal + " para " + dias + " dias.");
		} else {
			System.out.println("Erro: Quarto não está ocupado.");
		}
	}

	public void cancelarReserva(int numeroReserva) {
		Reserva reservaParaCancelar = null;
		for (Reserva reserva : listaReservas) {
			if (reserva.getProtocoloReserva() == numeroReserva) {
				reservaParaCancelar = reserva;
				break;
			}
		}
		if (reservaParaCancelar == null) {
			System.out.println("Erro: Reserva não encontrada.");
			return;
		}

		listaReservas.remove(reservaParaCancelar);
		Quarto quarto = reservaParaCancelar.getQuarto();
		quarto.setEstaDisponivel(true);

		System.out.println("Reserva cancelada com sucesso para o quarto " + quarto.getNumeroQuarto());
	}

	public int gerarProtocoloUnico() {
		Random random = new Random();
		int protocolo;
		for (int i = 0; i < 100; i++) {
			protocolo = random.nextInt(10000);
			boolean existe = false;
			for (Reserva reserva : listaReservas) {
				if (reserva.getProtocoloReserva() == protocolo) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				return protocolo;
			}
		}
		return -1;
	}

	public void listaReservas() {
		if (listaReservas.isEmpty()) {
			System.out.println("Nenhuma reserva encontrada.");
			return;
		}

		for (Reserva reserva : listaReservas) {
			Quarto quarto = reserva.getQuarto();
			Hospede hospede = reserva.getHospede();

			System.out.println("Reserva Protocolo: " + reserva.getProtocoloReserva());
			System.out.println("Hóspede: " + hospede.getNome());
			System.out.println("Quarto: " + quarto.getNumeroQuarto() + " - Tipo: " + quarto.getTipo());
			System.out.println("Data de Entrada: " + reserva.getDataEntrada());
			System.out.println("Data de Saída: " + reserva.getDataSaida());
			// operador ternario:
			System.out.println("Status do Quarto: " + (!quarto.isEstaDisponivel() ? "Ocupado" : "Disponível"));
			System.out.println("-----------------------------------");
		}
	}

	public void listarQuartosDisponiveis() {
		for (Quarto quarto : gerenciadorQuarto.get) {
			if (quarto.isEstaDisponivel()) {
				System.out.println("Número do Quarto: " + quarto.getNumeroQuarto());
				System.out.println("Tipo: " + quarto.getTipo());
				System.out.println("Capacidade: " + quarto.getCapacidade());
				System.out.println("Valor da Diária: R$ " + quarto.getValorDiaria());
				System.out.println("-----------------------------------");
			}
		}
	}

}
