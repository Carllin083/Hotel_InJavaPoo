package Gerenciadores;

import java.util.ArrayList;
import SistemaMain.Quarto;

public class GerenciadorQuarto {
	ArrayList<Quarto> listaQuartos = new ArrayList<>();
	//todos os metodos que envolvem gerenciamento de quartos
	
	public void cadastrarQuarto(Quarto quartoNovo) {
		//sempre cadastrar os quartos com numero deles em ordem cresce no Array
		//ex: <1,4,8>
	}
	
	//ocupado ou não, dependendo do parametro
	public void visualizarQuartos(boolean statusQuarto) {
		if(statusQuarto) {
			//mostra quartos disponiveis
		}else {
			//mostra quartos indisponiveis
		}
	}
	//aconselho mudar o status por set e get
	public String atualizarStatusQuarto() {
		return "Quarto atualizado com sucesso";
	}
	
}
