package SistemaMain;

import java.util.InputMismatchException;
import java.util.Scanner;
import Gerenciadores.GerenciadorFuncionario;
import Gerenciadores.GerenciadorHospede;
import Gerenciadores.GerenciadorQuarto;
import Gerenciadores.GerenciadorReserva;
import Usuarios.Hospede;

public class GerenciadorHotel {

	private static Scanner scanner = new Scanner(System.in);
	private static GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario();
	private static GerenciadorHospede gerenciadorHospede = new GerenciadorHospede();
	private static GerenciadorQuarto gerenciadorQuarto = new GerenciadorQuarto();
	private static GerenciadorReserva gerenciadorReserva = new GerenciadorReserva(gerenciadorHospede,
			gerenciadorQuarto);

	public static void main(final String[] args) {
		int opcao = 0;

		do {
			System.out.println("=== Menu do Gerenciador de Hotel ===");
			System.out.println("1. Gerenciador de Quartos");
			System.out.println("2. Gerenciador de Hóspedes");
			System.out.println("3. Gerenciador de Reservas");
			System.out.println("4. Gerenciador de Funcionários");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					System.out.println("Você escolheu Gerenciador de Quartos.");
					menuQuarto();
					break;
				case 2:
					System.out.println("Você escolheu Gerenciador de Hospedes.\n");
					menuHospedes();
					break;
				case 3:
					System.out.println("Você escolheu Gerenciador de Reservas.\n");
					menuReservas();
					break;
				case 4:
					System.out.println("Você escolheu Gerenciador de Funcionarios. \n");
					menuFuncionarios();
					break;
				case 5:
					System.out.println("Saindo...");
					System.out.println("==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
					System.out.println("Obrigado por usar nosso sistema!!");
					System.out.println("==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, insira um número válido.");
				scanner.nextLine();
			}

			System.out.println();
		} while (opcao != 5);

		scanner.close();
	}

	static private void menuQuarto() {
		int numQuarto;
		int capacidade;

		int opcao = 0;
		do {
			System.out.println("=== Gerenciador de Funcionários ===");
			System.out.println("1. Cadastrar Quarto");
			System.out.println("2. Buscar Quartos pelo numero");
			System.out.println("3. Listar todos os Quartos");
			System.out.println("4. Atualizar Quarto");
			System.out.println("Listar quartos disponiveis");
			System.out.println("6. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					System.out.println("Digite um numero para o quarto: ");
					numQuarto = scanner.nextInt();
					System.out.println("Digite o tipo do Quarto (SIMPLES, DUPLO, SUITE): ");
					tipoQuarto tipo = selecionarTipoQuarto();
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					System.out.println("Opção selecionada foi: " + tipo);
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
					System.out.println("\nDefina a capacidade total do Quarto: ");
					capacidade = scanner.nextInt();
					double valorDiaria1 = selecionarValor(tipo);
					System.out.println("\nValor da diaria do Quarto: " + valorDiaria1);
					gerenciadorQuarto.cadastrarQuarto(numQuarto, tipo, capacidade, valorDiaria1);
					break;
				case 2:
					System.out.println("\nDigite o numero do Quarto: \n");
					numQuarto = scanner.nextInt();
					gerenciadorQuarto.buscarQuarto(numQuarto);
					break;

				case 3:
					System.out.println("\nListando todos os quartos\n ");
					gerenciadorQuarto.getListaQuartos();
					break;

				case 4:
					System.out.println("\nAtualizendo todos os quartos\n");
					System.out.println("\nDigite o numero do Quarto: ");
					numQuarto = scanner.nextInt();
					System.out.println("\nEsta disponivel ? ");

				}

			} catch (Exception e) {

			}

		} while (opcao != 5);
	}

	static private void menuHospedes() {
		int opcao;
		String cpf;
		String nome;
		String data;
		String endereco;
		String contato;
		do {
			System.out.println("\n>>>>>>>>>> GERENCIADOR DE HÓSPEDES <<<<<<<<<\n");
			System.out.println("Opções: \n [1]Cadastrar Novo hóspede \n " + "[2]Listar Hóspedes cadastrados \n "
					+ "[3]Pesquisar hóspede \n " + "[4]Editar cadastro de Hóspede \n " + "[5]Voltar ao menu principal");
			System.out.println("Digite sua opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			try {

				switch (opcao) {
				case 1:
					System.out.println("=-==-=-==-=-=-=-=-=-=-=-=-=-=-");
					System.out.println("Informe os dados do hóspede");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

					System.out.println("Digite o CPF do hóspede: ");
					cpf = scanner.nextLine().trim();

					System.out.println("Digite o nome do hóspede: ");
					nome = scanner.nextLine().trim();

					System.out.println("Digite a data de nascimento do hóspede: ");
					data = scanner.nextLine().trim();

					System.out.println("Digite o endereço do hóspede: ");
					endereco = scanner.nextLine().trim();

					System.out.println("Digite o contato do hóspede: ");
					contato = scanner.nextLine().trim();
					gerenciadorHospede.cadastrar(nome, cpf, data, endereco, contato);

					break;

				case 2:
					gerenciadorHospede.listar();
					break;

				case 3:
					System.out.println("Digite o cpf do hóspede: ");
					cpf = scanner.nextLine();
					gerenciadorHospede.buscarHospede(cpf);
					break;

				case 4:
					System.out.println("Digite o CPF do hóspede: ");
					cpf = scanner.nextLine().trim();

					Hospede hospedeExistente = gerenciadorHospede.buscaPorCpf(cpf); // Verifica se o hóspede existe

					if (hospedeExistente != null) { // Se o hóspede foi encontrado, permite a edição
						System.out.println("Digite o nome atualizado do hóspede: ");
						nome = scanner.nextLine().trim();

						System.out.println("Digite o endereço atualizado do hóspede: ");
						endereco = scanner.nextLine().trim();

						System.out.println("Digite o contato atualizado do hóspede: ");
						contato = scanner.nextLine().trim();
						gerenciadorHospede.editar(cpf, nome, endereco, contato);
					}
					break;

				case 5:
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Retornando ao menu principal...\n");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

				default:
					System.out.println("Opção Inválida, tente novamente");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("ERRO: " + e.getMessage());
				scanner.nextLine();
			}

		} while (opcao != 5);

	}

	private static void menuReservas() {
		int opcao = 0;
		do {
			System.out.println("=== Gerenciador de Reservas ===");
			System.out.println("1. Criar Reserva (Check-in)");
			System.out.println("2. Cancelar Reserva");
			System.out.println("3. Verificar Disponibilidade");
			System.out.println("4. Check-out");
			System.out.println("5. Voltar");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					System.out.print("\nMenu de Check-in\n");
					System.out.print("Digite o CPF do hóspede: ");
					String cpf = scanner.nextLine();
					validarCPF(cpf);

					System.out.print("Digite o número do quarto: ");
					int numeroQuarto = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Data de entrada (AAAA-MM-DD): ");
					final String dataEntrada = scanner.nextLine();

					System.out.print("Data de saída (AAAA-MM-DD): ");
					String dataSaida = scanner.nextLine();
					gerenciadorReserva.criarReserva(cpf, numeroQuarto, dataEntrada, dataSaida);
					break;

				case 2:
					System.out.print("\nMenu de cancelamento");
					System.out.print("Digite o numero da reserva: ");
					int numeroReserva = scanner.nextInt();
					gerenciadorReserva.cancelarReserva(numeroReserva);
					break;

				case 3:
					System.out.print("Quartos disponiveis");
					gerenciadorReserva.listarQuartosDisponiveis();
					break;

				case 4:
					System.out.print("\nMenu de Check-out");
					System.out.print("Digite o número da reserva: ");
					int numeroReservaCheckOut = scanner.nextInt();
					scanner.nextLine();
					gerenciadorReserva.checkOut(numeroReservaCheckOut);
					break;

				case 5:
					System.out.println("Voltando ao menu principal...");
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, insira um número válido.");
				scanner.nextLine();
			}

			System.out.println();
		} while (opcao != 5);
	}

	private static void menuFuncionarios() {
		int opcao = 0;

		do {
			System.out.println("=== Gerenciador de Funcionários ===");
			System.out.println("1. Cadastrar Funcionário");
			System.out.println("2. Editar Informações do Funcionário");
			System.out.println("3. Registrar Horas de Trabalho");
			System.out.println("4. Calcular Salário");
			System.out.println("5. Listar Funcionários");
			System.out.println("6. Voltar");
			System.out.print("Escolha uma opção: ");

			opcao = scanner.nextInt();
			scanner.nextLine();

			try {

				switch (opcao) {
				case 1:
					System.out.print("CPF: ");
					String cpf = scanner.nextLine();
					validarCPF(cpf);

					System.out.print("Nome do funcionário: ");
					String nome = scanner.nextLine();

					System.out.print("Cargo: ");
					String cargo = scanner.nextLine();

					System.out.print("Salário: ");
					double salario = scanner.nextDouble();
					scanner.nextLine();

					System.out.print("Turno (diurno/noturno): ");
					String turno = scanner.nextLine();

					gerenciadorFuncionario.cadastrarFuncionario(nome, cpf, cargo, turno, salario, opcao);
					break;

				case 2:
					System.out.print("Digite o CPF do funcionário que deseja editar: ");
					cpf = scanner.nextLine();
					validarCPF(cpf);

					System.out.print("Nome do funcionário: ");
					nome = scanner.nextLine();

					System.out.print("Cargo: ");
					cargo = scanner.nextLine();

					System.out.print("Salário por hora: ");
					double salarioPorHora = scanner.nextDouble();
					scanner.nextLine();

					System.out.print("Turno (diurno/noturno): ");
					turno = scanner.nextLine();

					if (gerenciadorFuncionario.estaCadastrado(cpf)) {
						gerenciadorFuncionario.editarFuncionario(nome, cpf, cargo, salarioPorHora, turno);
					} else {
						System.out.println("Funcionário não encontrado.");
					}
					break;

				case 3:
					System.out.print("Digite o CPF do funcionário para registrar horas: ");
					cpf = scanner.nextLine();
					validarCPF(cpf);
					System.out.print("Digite a quantidade de horas trabalhadas no mês: ");
					int horasTrabalhadas = scanner.nextInt();
					gerenciadorFuncionario.registrarHoras(horasTrabalhadas, cpf);
					break;

				case 4:
					System.out.print("Digite o CPF do funcionário para calcular salário: ");
					cpf = scanner.nextLine();
					gerenciadorFuncionario.calcularHoras(cpf);
					break;

				case 5:
					System.out.println("Lista de Funcionários:");
					gerenciadorFuncionario.listarFuncionarios();
					break;

				case 6:
					System.out.println("Voltando ao menu principal...");
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, insira um número válido.");
				scanner.nextLine();
			}

			System.out.println();
		} while (opcao != 6);
	}

	private static boolean validarCPF(String cpf) {
		if (cpf.length() != 9) {
			return false;
		}

		for (char c : cpf.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	public static tipoQuarto selecionarTipoQuarto() {
		while (true) {
			try {
				System.out.println("\nEscolha o tipo de quarto:");
				System.out.println("1. SOLTEIRO");
				System.out.println("2. CASAL");
				System.out.println("3. SUITE");

				System.out.print("Escolha uma opção (1-3): ");
				int tipoOpcao = scanner.nextInt();
				scanner.nextLine(); // Limpa o buffer do scanner

				switch (tipoOpcao) {
				case 1:
					return tipoQuarto.SOLTEIRO;
				case 2:
					return tipoQuarto.CASAL;
				case 3:
					return tipoQuarto.SUITE;
				default:
					System.out.println("Opção inválida. Por favor, escolha entre 1 e 3.");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"=-=-=-=-=-\n  ERROR\n=-=-=-=-=-=-\n\nSelecione as opções através da numeração do mesmo\n");
				scanner.nextLine();
			}
		}
	}

	private static double selecionarValor(tipoQuarto tipo) {
		switch (tipo) {

		case SOLTEIRO:
			return 100.00;
		case CASAL:
			return 150.00;
		case SUITE:
			return 250.00;
		default:
			return 0.0;
		}
	}
}
