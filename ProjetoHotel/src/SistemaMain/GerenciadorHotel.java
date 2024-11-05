package br.com.terminalhotel.principal;

import java.util.InputMismatchException;
import java.util.Scanner;

import excecoes.CpfInvalidoException;
import gerenciadores.GerenciadorHospede;

public class GerenciadorHotel {
	private static GerenciadorHospede gerenciador = new GerenciadorHospede();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;

		do {
			System.out.println("=== Menu do Gerenciador de Hotel ===");
			System.out.println("1. Gerenciador de Quartos");
			System.out.println("2. Hóspedes");
			System.out.println("3. Reservas");
			System.out.println("4. Funcionários");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.println("Você escolheu Gerenciador de Quartos.");
					break;
				case 2:
					menuHospedes();
					break;
	
				case 3:
					System.out.println("Você escolheu Reservas.");
	
					break;
				case 4:
					System.out.println("Você escolheu Funcionários.");
	
					break;
				case 5:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
			System.out.println();
		} while (opcao != 5);

		scanner.close();

	}


	static private void menuHospedes() {
		int opcao;
		String cpf;
		String nome;
		String data;
		String endereco;
		String contato;
		do {
			System.out.println(">>>>>>>>>> GERENCIADOR DE HÓSPEDES <<<<<<<<<");
			System.out.println("Opções: \n [1]Cadastrar Novo hóspede \n " + "[2]Listar Hóspedes cadastrados \n "
					+ "[3]Pesquisar hóspede \n " + "[4]Editar cadastro de Hóspede \n " + "[5]Voltar ao menu principal");
			System.out.println("Digite sua opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			try {

				switch (opcao) {
				case 1:
					System.out.println("Digite o cpf do hóspede: ");
					cpf = scanner.nextLine().trim();

					System.out.println("Digite o nome do hóspede: ");
					nome = scanner.nextLine().trim();

					System.out.println("Digite a data de nascimento do hóspede: ");
					data = scanner.nextLine().trim();

					System.out.println("Digite o endereço do hóspede: ");
					endereco = scanner.nextLine().trim();

					System.out.println("Digite o contato do hóspede: ");
					contato = scanner.nextLine().trim();

					gerenciador.cadastrar(nome, cpf, data, endereco, contato);
					break;

				case 2:
					gerenciador.listarHospedes();
					break;

				case 3:
					System.out.println("Digite o cpf do hóspede: ");
					cpf = scanner.nextLine();
					gerenciador.buscarHospede(cpf);
					break;

				case 4:
					System.out.println("Digite o cpf do hóspede: ");
					cpf = scanner.nextLine().trim();

					System.out.println("Digite o nome atualizado do hóspede: ");
					nome = scanner.nextLine().trim();

					System.out.println("Digite o endereço atualizado do hóspede: ");
					endereco = scanner.nextLine().trim();

					System.out.println("Digite o contato atualizado do hóspede: ");
					contato = scanner.nextLine().trim();

					gerenciador.editar(cpf, nome, endereco, contato);
					break;

				default:
					System.out.println("Opção Inválida, tente novamente");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, insira um número válido.");
				scanner.nextLine();
			}

		} while (opcao != 5);
	
	}
}
