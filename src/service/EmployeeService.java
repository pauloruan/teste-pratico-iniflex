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

    public void addEmployee(String name, LocalDate birthDate, BigDecimal salary, String position) {
        Employee employee = new Employee(name, birthDate, salary, position);
        employees.add(employee);
    }

    public void removeEmployee(String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public void printEmployees() {
        System.out.println("Funcionários:");
        for (Employee employee : employees) {
            System.out.println("Nome: " + employee.getName()
                    + " - Data de Nascimento: " + employee.getFormattedBirthDate()
                    + " - Salário: " + employee.getFormattedSalary()
                    + " - Função: " + employee.getPosition()
                    + "."
            );
        }
        System.out.println("\n");
    }

    public void updateEmployeeSalary(Employee employee, double percentage) {
        employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1 + percentage)));
    }

    public void groupEmployeesByPosition() {
        for (Employee employee : employees) {
            if (!employeesByPosition.containsKey(employee.getPosition())) {
                employeesByPosition.put(employee.getPosition(), new ArrayList<>());
            }
            employeesByPosition.get(employee.getPosition()).add(employee);
        }
    }

    public void printEmployeesByPosition() {
        this.groupEmployeesByPosition();
        for (String position : employeesByPosition.keySet()) {
            System.out.println("Funcionários com função " + position + ":");
            for (Employee employee : employeesByPosition.get(position)) {
                System.out.println("Nome: " + employee.getName()
                        + " - Data de Nascimento: " + employee.getFormattedBirthDate()
                        + " - Salário: " + employee.getFormattedSalary()
                        + " - Função: " + employee.getPosition()
                        + "."
                );
            }
            System.out.println("\n");
        }
    }

    public void filterEmployeesByBirthdayMonth(int mes) {
        for (Employee employee : employees) {
            if (employee.getBirthDate().getMonthValue() == mes) {
                System.out.println("Nome: " + employee.getName()
                        + " - Data de Nascimento: " + employee.getFormattedBirthDate()
                        + " - Salário: " + employee.getFormattedSalary()
                        + " - Função: " + employee.getPosition()
                        + "."
                );
            }
        }
        System.out.println("\n");
    }

    public void printBirthdayEmployees() {
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        filterEmployeesByBirthdayMonth(10);
        filterEmployeesByBirthdayMonth(12);
    }

    public void printOldestEmployee() {
        Employee oldestEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getBirthDate().getYear() < oldestEmployee.getBirthDate().getYear()) {
                oldestEmployee = employee;
            }
        }
        System.out.println("Funcionário com maior idade:");
        System.out.println("Nome: " + oldestEmployee.getName()
                + " - Idade: " + Period.between(oldestEmployee.getBirthDate(), LocalDate.now()).getYears()
                + "."
        );
        System.out.println("\n");
    }

    public void printEmployeesInAlphabeticalOrder() {
        List<Employee> employeesSorted = new ArrayList<>(employees);
        employeesSorted.sort(Comparator.comparing(Person::getName));
        System.out.println("Funcionários em ordem alfabética:");
        for (Employee employee : employeesSorted) {
            System.out.println("Nome: " + employee.getName()
                    + " - Data de Nascimento: " + employee.getFormattedBirthDate()
                    + " - Salário: " + employee.getFormattedSalary()
                    + " - Função: " + employee.getPosition()
                    + "."
            );
        }
        System.out.println("\n");
    }

    public void printTotalSalaries() {
        BigDecimal totalSalaries = BigDecimal.ZERO;
        NumberFormat formattedTotalSalaries = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (Employee employee : employees) {
            totalSalaries = totalSalaries.add(employee.getSalary());
        }
        System.out.println("Total dos salários dos funcionários: " + formattedTotalSalaries.format(totalSalaries) + "\n");
    }

    public void printMinimumWages() {
        BigDecimal minimumWage = BigDecimal.valueOf(1212.00);
        for (Employee employee : employees) {
            System.out.println("Nome: " + employee.getName()
                    + " - Salário: " + employee.getFormattedSalary()
                    + " - Salários Mínimos: " + employee.getSalary().divide(minimumWage,2, RoundingMode.FLOOR)
            );
        }
        System.out.println("\n");
    }
}
