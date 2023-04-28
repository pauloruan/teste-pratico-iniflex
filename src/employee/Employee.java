package employee;

import person.Person;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Employee extends Person {
    private BigDecimal salary;
    private String position;

    public Employee(String name, LocalDate birthDate, BigDecimal salary, String position) {
        super(name, birthDate);
        this.salary = salary;
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFormattedSalary() {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(salary);
    }
}
