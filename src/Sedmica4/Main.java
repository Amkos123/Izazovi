package Sedmica4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("employees.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                int id = Integer.parseInt(parts[2]);
                double salary = Double.parseDouble(parts[3]);
                LocalDate dateOfJoining = LocalDate.parse(parts[4]);

                if (type.equals("EMPLOYEE")) {
                    employees.add(new Employee(name, id, salary, dateOfJoining));
                } else if (type.equals("MANAGER")) {
                    double bonus = Double.parseDouble(parts[5]);
                    employees.add(new Manager(name, id, salary,dateOfJoining ,bonus ));
                } else if (type.equals("PARTTIMEEMPLOYEE")) {
                    int workhours = Integer.parseInt(parts[5]);
                    employees.add(new PartTimeEmployee(name, id, salary, dateOfJoining, workhours));
                }
            }
        } catch (IOException e) {
            System.out.println("Greska u čitanju file-a" + e.getMessage());
        }
        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                System.out.println(e.getDetails());
                e.work();
            }
            System.out.println("Total salary: " + getTotalSalary(employees));
            sortbySalary(employees);
            upisiUFajl(employees);
            employeeOfTheMonth();
            searchEmployeeById(employees, 102);
        } else {
            System.out.println("Employee list is empty");
            System.exit(0);
        }

    }

    public static int getTotalSalary(ArrayList<Employee> employees) {
        double totalSalary = 0;
        for (Employee e : employees) {
            totalSalary += e.getSalary();
        }
        int totalSalaryint = (int) totalSalary;
        return totalSalaryint;
    }

    public static void sortbySalary(ArrayList<Employee> employees) {
        Collections.sort(employees);
        System.out.println("Employees sorted by salary:");
        for (Employee e : employees) {
            System.out.println(e.getDetails());
        }
    }

    public static void upisiUFajl(ArrayList<Employee> employees) {
        sortbySalary(employees);
        try (FileWriter writer = new FileWriter("employees_sorted.txt")) {
            for (Employee e : employees) {
                if (e instanceof Manager) {
                    writer.write("MANAGER," + e.getName() + "," + e.getId() + "," + (e.getSalary() - ((Manager) e).getBonus()) + "," + e.getDateOfJoining() + "," + ((Manager) e).getBonus() + "\n");
                } else if (e instanceof PartTimeEmployee) {
                    writer.write("PARTTIMEEMPLOYEE," + e.getName() + "," + e.getId() + "," + e.getSalary() + "," + e.getDateOfJoining() + "," + ((PartTimeEmployee) e).getWorkhours() + "\n");
                } else {
                    writer.write("EMPLOYEE," + e.getName() + "," + e.getId() + "," + e.getSalary() + "," + e.getDateOfJoining() + "\n");
                }
            }
            System.out.println("Employees sorted by salary have been written to employees_sorted.txt");
        } catch (IOException e) {
            System.out.println("Greska u pisanju file-a" + e.getMessage());
        }

    }
    public static void employeeOfTheMonth() {
        Employee employee = null;
        try (BufferedReader br2 = new BufferedReader(new FileReader("employees_sorted.txt"))) {

            String line = br2.readLine();


            String[] parts = line.split(",");
            String type = parts[0];
            String name = parts[1];
            int id = Integer.parseInt(parts[2]);
            double salary = Double.parseDouble(parts[3]);
            LocalDate dateOfJoining = LocalDate.parse(parts[4]);
            if (type.equals("EMPLOYEE")) {
                employee = new Employee(name, id, salary, dateOfJoining);
            } else if (type.equals("MANAGER")) {
                double bonus = Double.parseDouble(parts[5]);
                employee = new Manager(name, id, salary, dateOfJoining, bonus);
            } else if (type.equals("PARTTIMEEMPLOYEE")) {
                int workhours = Integer.parseInt(parts[5]);
                employee = new PartTimeEmployee(name, id, salary, dateOfJoining, workhours);
            }
            System.out.println("Employee of the month: " + employee.getDetails());

        } catch (IOException e) {
            System.out.println("Greska u čitanju file-a" + e.getMessage());
        }
    }
    public static void searchEmployeeById(ArrayList<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("Employee found: " + e.getDetails());
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
}
