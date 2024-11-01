package SistemaMain;
import java.time.LocalDate;
import Usuarios.Hospede;

public class Reserva{
    private Quarto quarto;
    private Hospede hospede;
    private String dataEntrada;
    private String dataSaida;

  public Reserva(Quarto quarto, Hospede hospede, String dataEntrada, String dataSaida){
    this.quarto = quarto;
    this.hospede = hospede;
    this.dataEntrada = dataEntrada;
    this.dataSaida = dataSaida;
  }
}