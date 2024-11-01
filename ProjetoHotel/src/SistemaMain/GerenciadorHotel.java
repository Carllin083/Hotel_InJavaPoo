package SistemaMain;

import java.util.Scanner;
import Gerenciadores.GerenciadorFuncionario;
import Gerenciadores.GerenciadorReserva;

public class GerenciadorHotel {
    
    
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorFuncionarios gerenciadorFuncionarios = new GerenciadorFuncionarios();
        GerenciadorReserva gerenciadorReserva = new GerenciadorReserva();
        
        int opcao;

        do {
            System.out.println("=== Menu do Gerenciador de Hotel ===");
            System.out.println("1. Gerenciador de Quartos");
            System.out.println("2. Gerenciador de Hóspedes");
            System.out.println("3. Gerenciador de Reservas");
            System.out.println("4. Gerenciador de Funcionários");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

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
            System.out.println();
        } while (opcao != 5);

        scanner.close();
    }
    
    private static void menuReservas() {
        int opcao;
        do {
            System.out.println("=== Gerenciador de Reservas ===");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Verificar Disponibilidade");
            System.out.println("4. Check-in");
            System.out.println("5. Check-out");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o CPF do hóspede: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite o número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Data de entrada (AAAA-MM-DD): ");
                    final String dataEntrada = scanner.nextLine();

                    System.out.print("Data de saída (AAAA-MM-DD): ");
                    final String dataSaida = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Digite o CPF do hóspede: ");
                    cpf = scanner.nextLine();
                    
                    System.out.print("Digite o número do quarto: ");
                    numeroQuarto = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    realizarCheckin();
                    break;
                case 5:
                    realizarCheckout();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        } while (opcao != 6);
    }
    private static void menuFuncionarios() {
        int opcao;

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
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    
                    System.out.print("Nome do funcionário: ");
                    String nome = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Salário por hora: ");
                    double salarioPorHora = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("Turno (diurno/noturno): ");
                    String turno = scanner.nextLine();
                    scanner.nextLine(); 

                    gerenciadorFuncionario.cadastrarFuncionario(nome, cpf, cargo, salario, turno);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o CPF do funcionário que deseja editar: ");
                    cpf = scanner.nextLine();

                    System.out.print("Nome do funcionário: ");
                    nome = scanner.nextLine();

                    System.out.print("Cargo: ");
                    cargo = scanner.nextLine();

                    System.out.print("Salário por hora: ");
                    salarioPorHora = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Turno (diurno/noturno): ");
                    turno = scanner.nextLine();
                    scanner.nextLine(); 

                    if(gerenciadorFuncionario.estaCadastrado(cpf)){
                        gerenciadorFuncionario.editarFuncionario(nome, cpf, cargo, salarioPorHora, turno);    
                    }else{
                        System.out.println("Funcionário não encontrado.");
                    }

                case 3:
                    System.out.print("Digite o CPF do funcionário para registrar horas: ");
                    final String nomeParaRegistrar = scanner.nextLine();

                case 4:
                    System.out.print("Digite o nome do funcionário para calcular salário: ");
                    final String nomeParaCalcular = scanner.nextLine();

                case 5:
                    System.out.println("Lista de Funcionários:");
            
                    break;

                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        } while (opcao != 6);
    }
}
