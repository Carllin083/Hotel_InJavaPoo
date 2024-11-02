package Gerenciadores;

import SistemaMain.Quarto;
import SistemaMain.TipoQuarto;
import java.util.ArrayList;

public class GerenciadorQuarto {
    private ArrayList<Quarto> listaQuartos = new ArrayList<>();

    /**
     * Cadastra um novo quarto no sistema.
     * @param numeroQuarto número do quarto
     * @param tipo tipo do quarto (solteiro, casal, suíte)
     * @param capacidade capacidade de hóspedes
     * @param valorDiaria valor da diária
     */
    public void cadastrarQuarto(int numeroQuarto, TipoQuarto tipo, int capacidade, int valorDiaria) {
        Quarto novoQuarto = new Quarto(numeroQuarto, tipo, capacidade, valorDiaria);
        listaQuartos.add(novoQuarto);
        System.out.println("Quarto cadastrado com sucesso: " + novoQuarto.getNumeroQuarto());
    }

    /**
     * Busca um quarto pelo número.
     * @param numeroQuarto número do quarto a ser buscado
     * @return o quarto encontrado ou null se não existir
     */
    public Quarto buscarQuarto(int numeroQuarto) {
        for (Quarto quarto : listaQuartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto) {
                return quarto;
            }
        }
        return null; // Retorna null se o quarto não for encontrado
    }

    /**
     * Lista todos os quartos disponíveis no hotel.
     * @return uma lista de quartos disponíveis
     */
    public ArrayList<Quarto> listarQuartosDisponiveis() {
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto quarto : listaQuartos) {
            if (quarto.isDisponivel()) {
                quartosDisponiveis.add(quarto);
            }
        }
        return quartosDisponiveis;
    }

    /**
     * Atualiza o status de disponibilidade de um quarto específico.
     * @param numeroQuarto número do quarto
     * @param disponivel verdadeiro se o quarto está disponível, falso se está ocupado
     */
    public void atualizarStatusQuarto(int numeroQuarto, boolean disponivel) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null) {
            quarto.setDisponivel(disponivel);
            System.out.println("Status do quarto atualizado: " + (disponivel ? "Disponível" : "Ocupado"));
        } else {
            System.out.println("Erro: Quarto não encontrado - " + numeroQuarto);
        }
    }
}
