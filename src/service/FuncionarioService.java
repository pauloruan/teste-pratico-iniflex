package service;

import funcionario.Funcionario;
import person.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FuncionarioService {
    public List<Funcionario> funcionarios = new ArrayList<>();
    public Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

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
        System.out.println("\n");
    }

    public void atualizarSalarioFuncionario(Funcionario funcionario, double percentual) {
        funcionario.setSalario(funcionario.getSalario().multiply(BigDecimal.valueOf(1 + percentual)));
    }

    public void agruparFuncionariosPorFuncao() {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionariosPorFuncao.containsKey(funcionario.getFuncao())) {
                funcionariosPorFuncao.put(funcionario.getFuncao(), new ArrayList<>());
            }
            funcionariosPorFuncao.get(funcionario.getFuncao()).add(funcionario);
        }
    }

    public void imprimirFuncionariosPorFuncao() {
        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("Funcionários com função " + funcao + ":");
            for (Funcionario funcionario : funcionariosPorFuncao.get(funcao)) {
                System.out.println("Nome: " + funcionario.getNome()
                        + " - Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                        + " - Salário: " + funcionario.getSalarioFormatado()
                        + " - Função: " + funcionario.getFuncao()
                        + "."
                );
            }
            System.out.println("\n");
        }
    }

    public void filtrarFuncionariosPorMesAniversario(int mes) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonthValue() == mes) {
                System.out.println("Nome: " + funcionario.getNome()
                        + " - Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                        + " - Salário: " + funcionario.getSalarioFormatado()
                        + " - Função: " + funcionario.getFuncao()
                        + "."
                );
            }
        }
        System.out.println("\n");
    }

    public void imprimirFuncionariosAniversariantes() {
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        filtrarFuncionariosPorMesAniversario(10);
        filtrarFuncionariosPorMesAniversario(12);
    }

    public void imprimirFuncionarioMaiorIdade() {
        Funcionario funcionarioMaiorIdade = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getYear() < funcionarioMaiorIdade.getDataNascimento().getYear()) {
                funcionarioMaiorIdade = funcionario;
            }
        }
        System.out.println("Funcionário com maior idade:");
        System.out.println("Nome: " + funcionarioMaiorIdade.getNome()
                + " - Idade: " + Period.between(funcionarioMaiorIdade.getDataNascimento(), LocalDate.now()).getYears()
                + "."
        );
        System.out.println("\n");
    }

    public void imprimirFuncionariosOrdemAlfabetica() {
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Pessoa::getNome));
        System.out.println("Funcionários em ordem alfabética:");
        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println("Nome: " + funcionario.getNome()
                    + " - Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                    + " - Salário: " + funcionario.getSalarioFormatado()
                    + " - Função: " + funcionario.getFuncao()
                    + "."
            );
        }
        System.out.println("\n");
    }

    public void imprimirTotalSalarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        NumberFormat totalSalariosFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        System.out.println("Total dos salários dos funcionários: " + totalSalariosFormatado.format(totalSalarios) + "\n");
    }

    public void imprimirSalariosMinimos() {
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome()
                    + " - Salário: " + funcionario.getSalarioFormatado()
                    + " - Salários Mínimos: " + funcionario.getSalario().divide(salarioMinimo,2, RoundingMode.FLOOR)
            );
        }
        System.out.println("\n");
    }
}
