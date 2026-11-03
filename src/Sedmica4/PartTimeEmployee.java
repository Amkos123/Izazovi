package Sedmica4;

public class PartTimeEmployee extends Employee {
    private int workhours;

    public PartTimeEmployee(String name, int id, double salary, int workhours) {
        super(name, id, salary);
        this.workhours = workhours;
    }

    public int getWorkhours() {
        return workhours;
    }

    @Override
    public void work(){
        System.out.println(getName() + " sometimes works.");
    }

    @Override
    public String getDetails(){
            return "ID: " + getId() + ", Name: " + getName() + ", Salary: " + getSalary() + " Workhours:" + workhours;
        }
    @Override
    public double getSalary() {
        return super.getSalary() * workhours;
    }
}



