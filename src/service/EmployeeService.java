package service;

import employee.Employee;
import person.Person;

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

public class EmployeeService {
    public List<Employee> employees = new ArrayList<>();
    public Map<String, List<Employee>> employeesByPosition = new HashMap<>();

    public static void printEmployeeDetails(Employee employee) {
        System.out.println("Nome: " + employee.getName()
                + " - Data de Nascimento: " + employee.getFormattedBirthDate()
                + " - Salário: " + employee.getFormattedSalary()
                + " - Função: " + employee.getPosition()
                + "."
        );
    }

    public void addEmployee(String name, LocalDate birthDate, BigDecimal salary, String position) {
        Employee employee = new Employee(name, birthDate, salary, position);
        employees.add(employee);
    }

    public void removeEmployee(String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public void printEmployees() {
        System.out.println("Funcionários:");
        employees.forEach(EmployeeService::printEmployeeDetails);
        System.out.println("\n");
    }

    public void updateEmployeeSalary(Employee employee, double percentage) {
        employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1 + percentage)));
    }

    public void updateEmployeesSalaries(double percentage) {
        employees.forEach(employee -> updateEmployeeSalary(employee, percentage));
    }

    public void groupEmployeesByPosition() {
        employees.forEach(employee -> {
            if (!employeesByPosition.containsKey(employee.getPosition())) {
                employeesByPosition.put(employee.getPosition(), new ArrayList<>());
            }
            employeesByPosition.get(employee.getPosition()).add(employee);
        });
    }

    public void printEmployeesByPosition() {
        this.groupEmployeesByPosition();
        employeesByPosition.forEach((position, employees) -> {
            System.out.println("Funcionários com função " + position + ":");
            employees.forEach(EmployeeService::printEmployeeDetails);
            System.out.println("\n");
        });
    }

    public void filterEmployeesByBirthdayMonth(int month) {
        employees.stream()
                .filter(employee -> employee.getBirthDate().getMonthValue() == month)
                .forEach(EmployeeService::printEmployeeDetails);
        System.out.println("\n");
    }

    public void printBirthdayEmployees() {
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        filterEmployeesByBirthdayMonth(10);
        filterEmployeesByBirthdayMonth(12);
    }

    public void printOldestEmployee() {
        employees.stream()
                .min(Comparator.comparing(employee -> employee.getBirthDate().getYear()))
                .ifPresent(employee -> {
                    System.out.println("Funcionário com maior idade:");
                    System.out.println("Nome: " + employee.getName()
                            + " - Idade: " + Period.between(employee.getBirthDate(), LocalDate.now()).getYears()
                            + ".\n"
                    );
                });
    }

    public void printEmployeesInAlphabeticalOrder() {
        System.out.println("Funcionários em ordem alfabética:");
        employees.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(EmployeeService::printEmployeeDetails);
        System.out.println("\n");
    }

    public void printTotalSalaries() {
        BigDecimal totalSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Soma total dos salários dos funcionários: " + NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(totalSalaries) + "\n");
    }

    public void printMinimumWages() {
        BigDecimal minimumWage = BigDecimal.valueOf(1212.00);
        employees.forEach(employee -> {
            System.out.println("Nome: " + employee.getName()
                    + " - Salário: " + employee.getFormattedSalary()
                    + " - Salários Mínimos: " + employee.getSalary().divide(minimumWage, 2, RoundingMode.FLOOR)
            );
        });
        System.out.println("\n");
    }
}
