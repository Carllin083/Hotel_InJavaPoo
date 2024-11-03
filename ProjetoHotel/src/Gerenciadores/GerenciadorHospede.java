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

	public Hospede buscarHospedePorCPF(String cpf) {
		for (Hospede hospedeAtual : listaHospedes) {
			if (hospedeAtual.getCpf().equals(cpf)) {
				System.out.println("\nHospede Localizado!!\n");
				System.out.println("Nome do Hospede: " + hospedeAtual.getNome() + "\nCPF do Hospede: " + hospedeAtual.getCpf());

			}
		}
		return null;
	}

	public void listarHospedes() {
		boolean hospedesEncontrado = false;
		if(listaHospedes.isEmpty() || listaHospedes == null) {
			System.out.println("Nenhum Hospede cadastrado ou encontrado");
		}else {
			for(Hospede hospedeAtual : listaHospedes) {
				System.out.println("Nome do Hospede: " + hospedeAtual.getNome());
			}
		}
	}

	public Hospede buscarHospede(String cpf) {
		for (Hospede hospede : listaHospedes) {
			if (hospede.getCpf().equals(cpf)) {
				return hospede;
			}
		}
		return null;
	}
}
