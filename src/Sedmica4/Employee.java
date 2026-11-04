package Sedmica4;

import java.time.LocalDate;
import java.time.Period;
public class Employee implements Comparable<Employee> ,Cloneable {
    private String name;
    private int id;
    private double salary;
    private LocalDate dateOfJoining;

    public Employee(String name, int id, double salary, LocalDate dateOfJoining) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void work() {
        System.out.println("Employee " + name + " is working.");
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + getSalary() + ", Date of Joining: " + dateOfJoining;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void getyearsofExperience() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfJoining, currentDate);
        System.out.println(name + " has " + period.getYears() + " years of experience.");
    }
        @Override
        public int compareTo (Employee other){
            return Double.compare(this.salary, other.salary);
        }
        @Override
        public Employee clone() {
        Employee clonedEmployee = null;
            try {
                clonedEmployee=(Employee) super.clone();
                clonedEmployee.dateOfJoining = LocalDate.of(dateOfJoining.getYear(), dateOfJoining.getMonth(), dateOfJoining.getDayOfMonth());
                return clonedEmployee;

            } catch (CloneNotSupportedException e) {
                throw new AssertionError(); // This should never happen since we are Cloneabl
            }

        }
    }


