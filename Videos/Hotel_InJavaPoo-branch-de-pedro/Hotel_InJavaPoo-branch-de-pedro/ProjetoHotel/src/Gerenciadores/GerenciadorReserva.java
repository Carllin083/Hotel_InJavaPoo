package Gerenciadores;

import SistemaMain.Reserva;
import SistemaMain.Quarto;
import Usuarios.Hospede;
import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorReserva {    

    private ArrayList<Reserva> listaReservas = new ArrayList<>();
    private GerenciadorHospede gerenciadorHospede;
    private GerenciadorQuarto gerenciadorQuarto;

    // Construtor padrão para permitir a criação de GerenciadorReserva sem parâmetros
    public GerenciadorReserva() {}

    // Construtor com parâmetros GerenciadorHospede e GerenciadorQuarto
    public GerenciadorReserva(GerenciadorHospede gerenciadorHospede, GerenciadorQuarto gerenciadorQuarto) {
        this.gerenciadorHospede = gerenciadorHospede;
        this.gerenciadorQuarto = gerenciadorQuarto;
    }

    public void criarReserva(String cpf, int numeroQuarto, String dataEntrada, String dataSaida){
        if (gerenciadorHospede == null || gerenciadorQuarto == null) {
            System.out.println("Erro: Dependências de hóspede ou quarto não configuradas.");
            return;
        }

        Hospede hospede = gerenciadorHospede.buscarHospede(cpf);
        if (hospede == null) {
            System.out.println("Erro: Hóspede não encontrado.");
            return;
        }

        Quarto quarto = gerenciadorQuarto.buscarQuarto(numeroQuarto);
        if (quarto == null || !quarto.isDisponivel()) {
            System.out.println("Erro: Quarto não encontrado ou indisponível.");
            return;
        }

        LocalDate entrada = LocalDate.parse(dataEntrada);
        LocalDate saida = LocalDate.parse(dataSaida);

        if (!saida.isAfter(entrada)) {
            System.out.println("Erro: A data de saída deve ser posterior à data de entrada.");
            return;
        }

        Reserva novaReserva = new Reserva(quarto, hospede, entrada, saida);
        listaReservas.add(novaReserva);
        quarto.setDisponivel(false); // Ocupa o quarto
        System.out.println("Reserva criada com sucesso para o quarto " + numeroQuarto);
    }

    // Outros métodos de GerenciadorReserva continuam aqui...
}
