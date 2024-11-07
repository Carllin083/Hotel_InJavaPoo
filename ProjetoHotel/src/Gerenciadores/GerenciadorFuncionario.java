package Gerenciadores;

import java.util.ArrayList;

import Usuarios.Funcionario;

public class GerenciadorFuncionario {
	private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

	public void cadastrarFuncionario(String nome, String cpf, String cargo, String turno, double salario, int horasTrabalhadas) {
		for (Funcionario funcionarioAtual : listaFuncionarios) {
			if (funcionarioAtual.getCpf().equals(cpf)) {
				System.out.println("Funcionário já cadastrado.");
				return;
			}
		}
		Funcionario novoFuncionario = new Funcionario (nome, cpf, cargo, turno, salario, horasTrabalhadas);
		listaFuncionarios.add(novoFuncionario);
		System.out.println("Funcionário cadastrado com sucesso.");
	}

	public void editarFuncionario(String nome, String cpf, String cargo, double salario, String turno) {
		for (Funcionario funcionarioAtual : listaFuncionarios) {
			if (funcionarioAtual.getCpf().equals(cpf)){
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

	public void listarFuncionarios() {
		if (listaFuncionarios.isEmpty()) {
			System.out.println("Nenhum funcionário cadastrado.");
		} else {
			for (Funcionario funcionario : listaFuncionarios) {
				System.out.println("Nome: " + funcionario.getNome() + ", CPF: " + funcionario.getCpf() + ", Cargo: "
						+ funcionario.getCargo() + ", Salário: " + funcionario.getSalario() + ", Turno: "
						+ funcionario.getTurno());
			}
		}
	}

	public void calcularHoras(String cpf) {
		if (estaCadastrado(cpf)) {
			for (Funcionario funcionarioAtual : listaFuncionarios) {
				if (funcionarioAtual.getCpf().equals(cpf)) {
					double salario = funcionarioAtual.getHorasTrabalhadas() * funcionarioAtual.getSalario();
					String salarioFormatado = String.format("R$ %.2f", salario).replace(".", ",");
					System.out.println(
							"O salário do funcionário " + funcionarioAtual.getNome() + " é de " + salarioFormatado);
					return;
				}
			}
		}
		System.out.println("Funcionário não encontrado");
	}

	public void registrarHoras(int horasTrabalhadas, String cpf) {
		if (estaCadastrado(cpf)) {
			for (Funcionario funcionarioAtual : listaFuncionarios) {
				if (funcionarioAtual.getCpf().equals(cpf)) {
					funcionarioAtual.setHorasTrabalhadas(horasTrabalhadas);
					return;
				}
			}
		}
		System.out.println("Funcionário não encontrado");
	}

}