package SistemaMain;

import java.time.LocalDate;
import Usuarios.Hospede;

public class Reserva {
    private Quarto quarto;
    private Hospede hospede;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    /**
     * Construtor para criar uma reserva.
     * Verifica se a data de saída é posterior à data de entrada.
     *
     * @param quarto O quarto reservado
     * @param hospede O hóspede que fez a reserva
     * @param dataEntrada Data de entrada na reserva
     * @param dataSaida Data de saída da reserva
     */
    public Reserva(Quarto quarto, Hospede hospede, LocalDate dataEntrada, LocalDate dataSaida) {
        if (dataSaida.isBefore(dataEntrada) || dataSaida.isEqual(dataEntrada)) {
            throw new IllegalArgumentException("A data de saída deve ser posterior à data de entrada.");
        }
        this.quarto = quarto;
        this.hospede = hospede;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
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
}
