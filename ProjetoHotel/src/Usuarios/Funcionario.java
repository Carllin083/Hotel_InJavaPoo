package Usuarios;

public class Funcionario extends Pessoa {
	public String cargo;
	public double salario;
	public String turno;
	public int horasTrabalhadas;

	public Funcionario(String nome, String cpf, String cargo, String turno, double salario) {
		super(nome, cpf, "Funcionario");
		this.cargo = cargo;
		this.salario = salario;
		this.turno = turno;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

}
