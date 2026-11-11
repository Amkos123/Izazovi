package Sedmica4;
import java.time.LocalDate;

public class Intern extends Employee {
    int durationinMonths;
    public Intern(String name, int id, double salary, LocalDate dateOfJoining, int durationinMonths) {
        super(name, id, salary, dateOfJoining);
        this.durationinMonths = durationinMonths;
    }
    @Override
    public void work() {
        System.out.println(getName() + " is working as an intern for " + durationinMonths + " months");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " and duration in months: " + durationinMonths;
    }
}
