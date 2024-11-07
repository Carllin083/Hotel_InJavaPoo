package SistemaMain;

import java.time.LocalDate;

import Usuarios.Hospede;

public class Reserva {
	private Quarto quarto;
	private Hospede hospede;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private int protocoloReserva;

	public Reserva(Quarto quarto, Hospede hospede, LocalDate dataEntrada, LocalDate dataSaida, int protocoloReserva) {
		if (dataSaida.isBefore(dataEntrada) || dataSaida.isEqual(dataEntrada)) {
			throw new IllegalArgumentException("A data de saída deve ser posterior à data de entrada.");
		}
		this.quarto = quarto;
		this.hospede = hospede;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.setProtocoloReserva(protocoloReserva);
	}

	// Getters
	public Quarto getQuarto() {
		return quarto;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public int getProtocoloReserva() {
		return protocoloReserva;
	}

	public void setProtocoloReserva(int protocoloReserva) {
		this.protocoloReserva = protocoloReserva;
	}

}