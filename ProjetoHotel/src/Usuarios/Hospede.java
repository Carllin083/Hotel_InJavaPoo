package Usuarios;

import SistemaMain.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Hospede extends Pessoa {
    private LocalDate dataNascimento;
    private String endereco;
    private List<Reserva> historico;
    private String contato;

    public Hospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
        super(nome, cpf, "Hospede");
        try {
            this.dataNascimento = LocalDate.parse(dataNascimento);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use o formato AAAA-MM-DD.");
            this.dataNascimento = null;
        }
        this.endereco = endereco;
        this.contato = contato;
        this.historico = new ArrayList<>();
    }

    // Getters e Setters
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        try {
            this.dataNascimento = LocalDate.parse(dataNascimento);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use o formato AAAA-MM-DD.");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return this.contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void adicionarReservaAoHistorico(Reserva reserva) {
        historico.add(reserva);
    }

    public List<Reserva> getHistorico() {
        return historico;
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma estadia registrada para este hóspede.");
        } else {
            System.out.println("Histórico de estadias de " + getNome() + ":");
            for (Reserva reserva : historico) {
                System.out.println("Quarto: " + reserva.getQuarto().getNumeroQuarto() +
                                   ", Entrada: " + reserva.getDataEntrada() +
                                   ", Saída: " + reserva.getDataSaida());
            }
        }
    }
}


