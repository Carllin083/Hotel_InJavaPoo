package Gerenciadores;
import java.util.ArrayList;
import Usuarios.Funcionario;

public class GerenciadorFuncionario {
  private ArrayList <Funcionario> listaFuncionarios = new ArrayList<>();

  public void cadastrarFuncionario(String nome, String cpf, String cargo, double salario, String turno) {
      for (Funcionario funcionarioAtual : listaFuncionarios) {
          if (funcionarioAtual.getCpf().equals(cpf)) {
              System.out.println("Funcionário já cadastrado");
              return;
          }
      }
      listaFuncionarios.add(new Funcionario(nome, cpf, cargo, salario, turno));
      System.out.println("Funcionário cadastrado com sucesso");
  }
  public void editarFuncionario(String nome, String cpf, String cargo, double salario, String turno) {
      for (Funcionario funcionarioAtual : listaFuncionarios) {
        if (funcionarioAtual.getCpf().equals(cpf)) {
            funcionarioAtual.setNome(nome);
            funcionarioAtual.setCargo(cargo);
            funcionarioAtual.setSalario(salario);
            funcionarioAtual.setTurno(turno);
            funcionarioAtual.setCpf(cpf);
            System.out.println("Funcionário editado com sucesso");
            return;
        }
      }
  }
  public boolean estaCadastrado(String cpf){
    for (Funcionario funcionarioAtual : listaFuncionarios) {
      if (funcionarioAtual.getCpf().equals(cpf)) {
          System.out.println("Funcionário encontrado");
          return true;
      }
    }
    System.out.println("Funcionário não encontrado");
    return false;
  }
}
