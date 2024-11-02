package Gerenciadores;

import java.util.ArrayList;
import Usuarios.Funcionario;

public class GerenciadorFuncionario {
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    /**
     * Cadastra um novo funcionário no sistema.
     * @param nome Nome do funcionário
     * @param cpf CPF do funcionário
     * @param cargo Cargo do funcionário
     * @param salario Salário do funcionário
     * @param turno Turno de trabalho do funcionário
     */
    public void cadastrarFuncionario(String nome, String cpf, String cargo, double salario, String turno) {
        for (Funcionario funcionarioAtual : listaFuncionarios) {
            if (funcionarioAtual.getCpf().equals(cpf)) {
                System.out.println("Funcionário já cadastrado.");
                return;
            }
        }
        listaFuncionarios.add(new Funcionario(nome, cpf, cargo, salario, turno));
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    /**
     * Edita as informações de um funcionário cadastrado.
     * @param nome Novo nome do funcionário
     * @param cpf CPF do funcionário (não editável)
     * @param cargo Novo cargo do funcionário
     * @param salario Novo salário do funcionário
     * @param turno Novo turno de trabalho do funcionário
     */
    public void editarFuncionario(String nome, String cpf, String cargo, double salario, String turno) {
        for (Funcionario funcionarioAtual : listaFuncionarios) {
            if (funcionarioAtual.getCpf().equals(cpf)) {
                funcionarioAtual.setNome(nome);
                funcionarioAtual.setCargo(cargo);
                funcionarioAtual.setSalario(salario);
                funcionarioAtual.setTurno(turno);
                System.out.println("Funcionário editado com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    /**
     * Verifica se um funcionário com o CPF especificado está cadastrado.
     * @param cpf CPF do funcionário
     * @return true se o funcionário estiver cadastrado, false caso contrário
     */
    public boolean estaCadastrado(String cpf) {
        for (Funcionario funcionarioAtual : listaFuncionarios) {
            if (funcionarioAtual.getCpf().equals(cpf)) {
                System.out.println("Funcionário encontrado.");
                return true;
            }
        }
        System.out.println("Funcionário não encontrado.");
        return false;
    }

    /**
     * Lista todos os funcionários cadastrados.
     */
    public void listarFuncionarios() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println("Nome: " + funcionario.getNome() +
                                   ", CPF: " + funcionario.getCpf() +
                                   ", Cargo: " + funcionario.getCargo() +
                                   ", Salário: " + funcionario.getSalario() +
                                   ", Turno: " + funcionario.getTurno());
            }
        }
    }
}
