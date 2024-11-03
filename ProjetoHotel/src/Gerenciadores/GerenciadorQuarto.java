package Gerenciadores;
import java.util.ArrayList;

public class GerenciadorQuarto {

	import SistemaMain.Quarto;

	public class GerenciadorQuarto {
		private ArrayList<Quarto> listaQuartos = new ArrayList<>(); //lista de quartos

		public void cadastrarQuarto(int numeroQuarto, int tipo, int capacidade, int valorDiaria) {//metodo cadastra novo quarto no sistema
			Quarto novoQuarto = new Quarto(numeroQuarto, tipo, capacidade, valorDiaria);
			listaQuartos.add(novoQuarto);
		}

		public void atualizarStatusQuarto(int numeroQuarto, String novoStatus) { //metodo que atualiza o status
		        for (Quarto quarto : listaQuartos) {
		            if (quarto.getNumero() == numeroQuarto) {
		                quarto.setStatus(novoStatus);
		                System.out.println("Status do quarto " + numeroQuarto + " atualizado para " + novoStatus);
		                return;
		            }
		        System.out.println("Quarto não encontrado.");
		    }
		        }
			
		public void visualizarQuartosdisponiveis() {
			System.out.println("Quartos Disponíveis");
	        boolean temDisponivel = false;
	        for (Quarto quarto : listaQuartos) {
	            if (quarto.getStatus().equalsIgnoreCase("disponível")) {
	                temDisponivel = true;
	                System.out.println("Numero: " + quarto.getNumero() + 
	                                   ", Tipo: " + quarto.getTipo() + 
	                                   ", Capacidade: " + quarto.getCapacidade() + 
	                                   ", Preço: " + quarto.getValorDiaria());
	            }
	        }
	        if (!temDisponivel) {
	            System.out.println("Não há quarto disponivel no momento");
	        }
	    }
	}
}

