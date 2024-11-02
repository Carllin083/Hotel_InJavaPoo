package SistemaMain;

import java.util.InputMismatchException;
import java.util.Scanner;

import Gerenciadores.GerenciadorFuncionario;
import Gerenciadores.GerenciadorHospede;
import Gerenciadores.GerenciadorQuarto;
import Gerenciadores.GerenciadorReserva;

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
					break;
				case 2:
					System.out.println("Você escolheu Hóspedes.");
					break;
				case 3:
					menuReservas();
					break;
				case 4:
					System.out.println("Você escolheu Funcionários.");
					menuFuncionarios();
					break;
				case 5:
					System.out.println("Saindo...");
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

			try {
				opcao = scanner.nextInt();
				scanner.nextLine();

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

					gerenciadorFuncionario.cadastrarFuncionario(nome, cpf, cargo, turno, salario);
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
}
