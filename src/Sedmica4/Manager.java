package Sedmica4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double salary, LocalDate dateOfJoining, double bonus) {
        super(name, id, salary, dateOfJoining);
        this.bonus = bonus;
    }
    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
    public double getBonus() {
        return bonus;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is managing the team");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " and with bonus " + bonus;
    }
}