import service.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste Prático - Iniflex\n");

        EmployeeService employeeService = new EmployeeService();

        //  Adicionar funcionários
        employeeService.addEmployee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
        employeeService.addEmployee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador");
        employeeService.addEmployee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador");
        employeeService.addEmployee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor");
        employeeService.addEmployee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista");
        employeeService.addEmployee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador");
        employeeService.addEmployee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador");
        employeeService.addEmployee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente");
        employeeService.addEmployee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista");
        employeeService.addEmployee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente");

        //  Remover funcionário "João"
        employeeService.removeEmployee("João");

        //  Imprimir todos os funcionários
        employeeService.printEmployees();

        // Atualizar salário dos funcionários em 10%
        employeeService.updateEmployeesSalaries(0.1);

        //  Imprimir funcionários agrupados por função
        employeeService.printEmployeesByPosition();

        //  Imprimir funcionários aniversariantes do mês 10 e 12
        employeeService.printBirthdayEmployees();

        //  Imprimir funcionário com maior idade
        employeeService.printOldestEmployee();

        //  Imprimir funcionários por ordem alfabética
        employeeService.printEmployeesInAlphabeticalOrder();

        //  Imprimir o total dos salários dos funcionários.
        employeeService.printTotalSalaries();

        //  Imprimir quantos salários mínimos ganha cada funcionário.
        employeeService.printMinimumWages();
    }
}