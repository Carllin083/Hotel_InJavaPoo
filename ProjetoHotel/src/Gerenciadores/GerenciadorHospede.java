package Gerenciadores;

import Exceções.CamposNaoPreenchidosException;
import Exceções.CpfInvalidoException;
import Usuarios.Hospede;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorHospede {
	Scanner sc = new Scanner(System.in);
	private ArrayList<Hospede> listaHospedes = new ArrayList<>();

	public GerenciadorHospede() {
	}

	public void cadastrar(String nome, String cpf, String dataNascimento, String endereco, String contato) {

		try {
			validacaoCpf(cpf);
			validacaoPreencimentoDeCampos(nome, cpf, dataNascimento);
			Hospede novoHospede = new Hospede(nome, cpf, dataNascimento, endereco, contato);
			listaHospedes.add(novoHospede);
			System.out.println("Novo Hóspede cadastrado com sucesso!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void editar(String cpf, String nome, String endereco, String contato) {
		Hospede hospedeCadastrado = buscaPorCpf(cpf);

		if (hospedeCadastrado != null) {
			hospedeCadastrado.setNome(nome);
			hospedeCadastrado.setEndereco(endereco);
			hospedeCadastrado.setContato(contato);

			System.out.println("Cadastro do hóspede " + hospedeCadastrado.getNome() + " atualizado com sucesso");

		} else {
			System.out.println("Nenhum cadastro de hóspede com o cpf " + hospedeCadastrado.getCpf() + " foi encontrado");
		}

	}

	public Hospede buscarHospede(String cpf) {
		boolean isEncontrou = false;
		for (Hospede hospede : listaHospedes) {
			if (hospede.getCpf().equalsIgnoreCase(cpf)) {
				isEncontrou = true;
				System.out.println("=-==-=-=-=-=--=-=\nENCONTRADO!!\n=-=-=-=-=-=-=-=-\n [Nome = " + hospede.getNome()
						+ "\n Endereço = " + hospede.getEndereco() + "\n Contato  = " + hospede.getContato() + "\n");
				break;
			}
		}

		if (!isEncontrou) {
			System.out.println("Hóspede não encontrado, por favor verifique se as informações foram passadas corretamente e tente novamente");
		}
		return null;
	}

	public void listarHospedes() {

		for (Hospede hospedeAtual : listaHospedes) {
			if (!listaHospedes.isEmpty()) {
				System.out.println("Hóspedes Cadastrados: ");
				for (Hospede hospede : listaHospedes) {
					System.out.println("Nome do Hospede: " + hospedeAtual.getNome() + "\n Data de Nascimento: "
							+ hospedeAtual.getDataNascimento());
				}
			} else {
				System.out.println("Não há hóspedes cadastrados!");
			}
		}
	}

	// MÉTODOS ADICIONAIS
	private Hospede buscaPorCpf(String cpf) {
		for (Hospede hospede : listaHospedes) {
			if (hospede.getCpf().equals(cpf)) {
				return hospede;
			}
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

}