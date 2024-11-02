package Gerenciadores;
import java.time.LocalDate;
import Usuarios.Hospede;
import SistemaMain.Quarto;

public class GerenciadorReserva {

    public void fazerReserva(Hospede hospede, Quarto quarto, LocalDate checkIn, LocalDate checkOut) {
        // Lógica para verificar disponibilidade e reservar o quarto
        hospede.adicionarEstadia(quarto, checkIn, checkOut);
        System.out.println("Reserva realizada com sucesso para " + hospede.getNome() + 
                           " no quarto " + quarto.getNumeroQuarto());
    }
}
