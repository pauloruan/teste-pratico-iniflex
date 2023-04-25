import funcionario.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste Prático - Iniflex\n");

        FuncionarioService funcionarioService = new FuncionarioService();

        //  Adicionar funcionários
        funcionarioService.adicionarFuncionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador");
        funcionarioService.adicionarFuncionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador");
        funcionarioService.adicionarFuncionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador");
        funcionarioService.adicionarFuncionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor");
        funcionarioService.adicionarFuncionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista");
        funcionarioService.adicionarFuncionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador");
        funcionarioService.adicionarFuncionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador");
        funcionarioService.adicionarFuncionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente");
        funcionarioService.adicionarFuncionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista");
        funcionarioService.adicionarFuncionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente");

        //  Remover funcionário "João"
        funcionarioService.removerFuncionario("João");

        //  Imprimir todos os funcionários
        funcionarioService.imprimirFuncionarios();

        // Atualizar salário dos funcionários em 10%
        for (Funcionario funcionario : funcionarioService.funcionarios) {
            funcionarioService.atualizarSalarioFuncionario(funcionario, 0.1);
        }

        //  Agrupar funcionários ordenados por função
        funcionarioService.agruparFuncionariosPorFuncao();

        //  Imprimir funcionários agrupados por função
        funcionarioService.imprimirFuncionariosPorFuncao();

        //  Imprimir funcionários aniversariantes do mês 10 e 12
        funcionarioService.imprimirFuncionariosAniversariantes();

        //  Imprimir funcionário com maior idade
        funcionarioService.imprimirFuncionarioMaiorIdade();
    }
}