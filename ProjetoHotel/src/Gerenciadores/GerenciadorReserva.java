package Gerenciadores;
import SistemaMain.Reserva;
import java.util.ArrayList;

public class GerenciadorReserva {    
  
  private ArrayList<Reserva> listaReservas = new ArrayList<>();

  public void criarReserva(int cpf, int numeroQuarto, String dataEntrada, String dataSaida){
    //preciso verificar se o hospede existe
    //preciso verificar se o quarto existe
    //preciso verificar se a data de entrada é menor que a data de saida
    //preciso verificar se o quarto está disponivel

    // Reserva novaReserva = new Reserva(quarto, hospede, dataEntrada, dataSaida);
    // listaReservas.add(novaReserva);
  }
  public void cancelarReserva(String cpf, int numeroQuarto){
    
  }
  public void verifcarDisponibilidade(String dataInicio, String dataFim){

  }
  public void realizarCheckin(){

  }
  public void realizarCheckout(){

  }
  
}
