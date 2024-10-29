package Sistema;

import java.util.Scanner;

public class GerenciadorHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu Gerenciador de Quartos.");
                    break;
                case 2:
                    System.out.println("Você escolheu Hóspedes.");
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
}
