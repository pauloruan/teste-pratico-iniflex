package service;

import funcionario.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    public List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        Funcionario funcionario = new Funcionario(nome, dataNascimento, salario, funcao);
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void imprimirFuncionarios() {
        System.out.println("Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome()
                    + " - Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                    + " - Salário: " + funcionario.getSalarioFormatado()
                    + " - Função: " + funcionario.getFuncao()
                    + "."
            );
        }
    }
}
