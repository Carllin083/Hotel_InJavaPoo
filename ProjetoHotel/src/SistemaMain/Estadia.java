package SistemaMain;

import java.time.LocalDate;

public class Estadia {

	private Quarto quarto;
	private LocalDate dataCheckIn;
	private LocalDate dataCheckOut;
	
	public Estadia(Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut ) {
		this.quarto = quarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;		
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
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
	
    public String toString() {
        return "Quarto: " + quarto.getNumeroQuarto() + 
               ", Check-in: " + dataCheckIn + 
               ", Check-out: " + dataCheckOut;
    }

}
