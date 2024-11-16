package Gerenciadores;

import java.util.Scanner;
import java.util.ArrayList;
import Exceções.CamposNaoPreenchidosException;
import Exceções.CpfInvalidoException;
import Interface.Gerenciadora;
import Usuarios.Hospede;

public class GerenciadorHospede implements Gerenciadora {
	Scanner sc = new Scanner(System.in);
	private ArrayList<Hospede> listaHospedes = new ArrayList<>();

	public GerenciadorHospede() {
	}

	public void cadastrar(String nome, String cpf, String dataNascimento, String endereco, String contato) {

		boolean dadosValido = false;
			try {
				validacaoPreencimentoDeCampos(nome, cpf, dataNascimento);
				Hospede novoHospede = new Hospede(nome, cpf, dataNascimento, endereco, contato);
				listaHospedes.add(novoHospede);
				System.out.println("Novo Hóspede cadastrado com sucesso!\n");
				System.out.println("Nome do Hóspede: " + nome);
				System.out.println("CPF cadastrado: " + cpf);
				System.out.println("Data de Nascimento: " + dataNascimento);
				System.out.println("Contato: " + contato);
				dadosValido = true;

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}


	}

	// se o hospede existir (!= null) editar nome, edereço e contato
	public void editar(String cpf, String nome, String endereco, String contato) {

		Hospede hospedeAtual = buscaPorCpf(cpf);

		if (hospedeAtual != null) {
			hospedeAtual.setNome(nome);
			hospedeAtual.setEndereco(endereco);
			hospedeAtual.setContato(contato);
			System.out.println("Hospede atualizado com sucesso!\n");
			System.out.println("Nome do Hospede: " + hospedeAtual.getNome());
			System.out.println("Endereço do Hospede: " + hospedeAtual.getEndereco());
			System.out.println("Contato do Hospede: " + hospedeAtual.getContato());
		}
	}

	public Hospede buscarHospede(String cpf) {
		boolean isEncontrou = false;
		for (Hospede hospede : listaHospedes) {
			if (hospede.getCpf().equalsIgnoreCase(cpf)) {
				isEncontrou = true;
				System.out.println("=-==-=-=-=-=--=-=\nENCONTRADO!!\n=-=-=-=-=-=-=-=-\nNome: " + hospede.getNome()
						+ "\n Endereço: " + hospede.getEndereco() + "\n Contato: " + hospede.getContato() + "\n");
				break;
			}
		}

		if (!isEncontrou) {
			System.out.println(
					"\nHóspede não encontrado, por favor verifique se as informações foram passadas corretamente e tente novamente");
		}
		return null;
	}

	public void listar() {

		if (listaHospedes.isEmpty()) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("Não há Hospedes cadastrados");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		} else {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("LISTANDO TODOS OS HOSPEDES");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-");
			for (Hospede hospedeAtual : listaHospedes) {
				System.out.println("Nome: " + hospedeAtual.getNome());
			}
		}
	}

	// MÉTODOS ADICIONAIS
	public Hospede buscaPorCpf(String cpf) {
		while (true) {
			for (Hospede hospede : listaHospedes) {
				if (hospede != null && hospede.getCpf().equalsIgnoreCase(cpf)) {
					System.out.println("Hospede encontrado: " + hospede.getNome());
					return hospede;
				}
			}
			System.out.println("Hospede com CPF " + cpf + " não encontrado na lista.");
			break;
		}
		return null;
	}

	public void validacaoCpf(String cpf) throws CpfInvalidoException {
		if (cpf == null || !cpf.matches("\\d{11}")) {
			throw new CpfInvalidoException("Erro: Cpf informado fora do formato válido");
		}

	}

	public void validacaoPreencimentoDeCampos(String nome, String cpf, String dataNascimento)
			throws CamposNaoPreenchidosException {
		if (nome.isBlank() || cpf.isBlank() || dataNascimento.isBlank()) { // Se algum dos campos forem
																			// verdadeiros,lança a exceçaõ
			throw new Exceções.CamposNaoPreenchidosException("Erro: Campos obrigatórios não preenchidos corretamente");
		}

	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void visualizar() {
		// TODO Auto-generated method stub

	}
}