package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

import SistemaMain.Estadia;
import SistemaMain.Quarto;

public class Hospede extends Pessoa {
	private String dataNascimento;
	private String endereco;
	private String[][][] historico;
	private String contato;
	private ArrayList<Estadia> listaEstadia = new ArrayList<>();
	private ArrayList<Hospede> ListaHospede = new ArrayList<>();

	public Hospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
		super(nome, cpf, "Hospede");
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.contato = contato;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String[][][] getHistorico() {
		return historico;
	}

	public void setHistorico(String[][][] historico) {
		this.historico = historico;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public void adicionarEstadia(Quarto quarto, LocalDate checkIn, LocalDate checkOut) {
		Estadia estadia = new Estadia(quarto, checkIn, checkOut);
		listaEstadia.add(estadia);
	}
	
	public void visualizarHistoricoEstadias(String nome, String cpf) {
		for(Hospede hospedeAtual : ListaHospede ) {
			if(hospedeAtual.getCpf().equalsIgnoreCase(cpf)) {
				System.out.println("Historico de Estadias de " + getNome());
			}
		}
	}

}
