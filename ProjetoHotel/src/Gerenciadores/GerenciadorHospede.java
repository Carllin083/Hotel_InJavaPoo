package Gerenciadores;

import java.util.ArrayList;

import Usuarios.Hospede;

public class GerenciadorHospede {
	private ArrayList<Hospede> listaHospedes = new ArrayList<>();

	public void cadastrarHospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
		Hospede novoHospede = new Hospede(nome, cpf, dataNascimento, endereco, contato);
		listaHospedes.add(novoHospede);
		System.out.println("Hospede cadastrado com sucesso");
	}

	public void editarHospede(String cpf) {
		// Implementação para editar o hóspede
	}

	public void buscarHospede(String cpf) {
		// Implementação para buscar o hóspede
	}

	public void listarHospedes() {

	}
}
