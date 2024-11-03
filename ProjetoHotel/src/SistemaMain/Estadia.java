package SistemaMain;

import java.time.LocalDate;

import Usuarios.Hospede;

public class Estadia {

	private Quarto quarto;
	private Hospede hospede;
	private LocalDate dataCheckIn;
	private LocalDate dataCheckOut;
	private int protocoloReserva;
	
	public Estadia(Quarto quarto, Hospede hospede, LocalDate dataCheckIn, LocalDate dataCheckOut, int protocoloReserva ) {
		this.quarto = quarto;
		this.hospede = hospede;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		this.setProtocoloReserva(protocoloReserva);
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(LocalDate dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(LocalDate dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}
	
	public int getProtocoloReserva() {
		return protocoloReserva;
	}
	
	private void setProtocoloReserva(int protocoloReserva) {
		this.protocoloReserva = protocoloReserva;
		
	}
	
    public String toString() {
        return "Quarto: " + quarto.getNumeroQuarto() + 
               ", Check-in: " + dataCheckIn + 
               ", Check-out: " + dataCheckOut;
    }

}
