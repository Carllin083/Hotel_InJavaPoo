package Gerenciadores;

import java.util.ArrayList;
import Usuarios.Hospede;

/**
 * Gerencia as operações relacionadas aos hóspedes, como cadastro, edição e busca.
 */
public class GerenciadorHospede {
    private ArrayList<Hospede> listaHospedes = new ArrayList<>();

    /**
     * Cadastra um novo hóspede no sistema, validando campos obrigatórios e evitando duplicação de CPF.
     * @param nome Nome do hóspede
     * @param cpf CPF do hóspede
     * @param dataNascimento Data de nascimento do hóspede
     * @param endereco Endereço do hóspede
     * @param contato Contato do hóspede
     */
    public void cadastrarHospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
        if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty()) {
            System.out.println("Erro: Todos os campos obrigatórios devem ser preenchidos.");
            return;
        }
        if (!validarCPF(cpf)) {
            System.out.println("Erro: CPF inválido. Por favor, insira um CPF válido.");
            return;
        }
        if (buscarHospede(cpf) != null) {
            System.out.println("Erro: Hóspede com CPF " + cpf + " já está cadastrado.");
            return;
        }
        
        Hospede novoHospede = new Hospede(nome, cpf, dataNascimento, endereco, contato);
        listaHospedes.add(novoHospede);
        System.out.println("Hóspede cadastrado com sucesso: " + nome);
    }

    /**
     * Busca um hóspede pelo CPF.
     * @param cpf CPF do hóspede
     * @return Objeto Hospede se encontrado, ou null se não encontrado
     */
    public Hospede buscarHospede(String cpf) {
        for (Hospede hospede : listaHospedes) {
            if (hospede.getCpf().equals(cpf)) {
                return hospede;
            }
        }
        return null;
    }

    /**
     * Edita o endereço e contato de um hóspede existente.
     * @param cpf CPF do hóspede
     * @param novoEndereco Novo endereço do hóspede
     * @param novoContato Novo contato do hóspede
     */
    public void editarHospede(String cpf, String novoEndereco, String novoContato) {
        Hospede hospede = buscarHospede(cpf);
        if (hospede != null) {
            hospede.setEndereco(novoEndereco);
            hospede.setContato(novoContato);
            System.out.println("Informações do hóspede atualizadas: " + hospede.getNome());
        } else {
            System.out.println("Erro: Hóspede não encontrado com o CPF: " + cpf);
        }
    }

    /**
     * Lista todos os hóspedes cadastrados.
     */
    public void listarHospedes() {
        if (listaHospedes.isEmpty()) {
            System.out.println("Nenhum hóspede cadastrado.");
        } else {
            System.out.println("Lista de Hóspedes:");
            for (Hospede hospede : listaHospedes) {
                System.out.println("Nome: " + hospede.getNome() +
                                   ", CPF: " + hospede.getCpf() +
                                   ", Data de Nascimento: " + hospede.getDataNascimento() +
                                   ", Endereço: " + hospede.getEndereco() +
                                   ", Contato: " + hospede.getContato());
            }
        }
    }

    /**
     * Valida o CPF com uma expressão regular simples.
     * @param cpf CPF do hóspede
     * @return Verdadeiro se o CPF for válido, falso caso contrário
     */
    private boolean validarCPF(String cpf) {
        // Exemplo básico: valida se tem 11 dígitos numéricos
        return cpf != null && cpf.matches("\\d{11}");
    }
}
