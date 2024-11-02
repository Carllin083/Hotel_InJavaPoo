package Gerenciadores;

import java.util.ArrayList;

import Usuarios.Hospede;

public class GerenciadorHospede {
	private ArrayList<Hospede> listaHospedes = new ArrayList<>();

	public void cadastrarHospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
		if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty()) {
			System.out.println("Erro: Todos os campos obrigatórios devem ser preenchidos.");
			return;
		}
		if (!validarCPF(cpf)) {
			System.out.println("Erro: CPF inválido. Por favor, insira um CPF válido.");
			return;
		}
		if (buscarHospede(cpf) != null) {
			System.out.println("Erro: Hóspede com CPF " + cpf + " já está cadastrado.");
			return;
		}

		Hospede novoHospede = new Hospede(nome, cpf, dataNascimento, endereco, contato);
		listaHospedes.add(novoHospede);
		System.out.println("Hóspede cadastrado com sucesso: " + nome);
	}

	public Hospede buscarHospede(String cpf) {
		for (Hospede hospede : listaHospedes) {
			if (hospede.getCpf().equals(cpf)) {
				return hospede;
			}
		}
		return null;
	}

	public void editarHospede(String cpf, String novoEndereco, String novoContato) {
		Hospede hospede = buscarHospede(cpf);
		if (hospede != null) {
			hospede.setEndereco(novoEndereco);
			hospede.setContato(novoContato);
			System.out.println("Informações do hóspede atualizadas: " + hospede.getNome());
		} else {
			System.out.println("Erro: Hóspede não encontrado com o CPF: " + cpf);
		}
	}

	public void listarHospedes() {
		if (listaHospedes.isEmpty()) {
			System.out.println("Nenhum hóspede cadastrado.");
		} else {
			System.out.println("Lista de Hóspedes:");
			for (Hospede hospede : listaHospedes) {
				System.out.println("Nome: " + hospede.getNome() + ", CPF: " + hospede.getCpf()
						+ ", Data de Nascimento: " + hospede.getDataNascimento() + ", Endereço: "
						+ hospede.getEndereco() + ", Contato: " + hospede.getContato());
			}
		}
	}

	private boolean validarCPF(String cpf) {
		return cpf != null && cpf.matches("\\d{11}");
	}
}
