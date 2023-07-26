package objectOrientedProgramming.pack7Association;
/**
 * Employee
 */
public abstract class Employee {
    protected String name;
    protected int experience;
    protected int salary;
    // public abstract void sayHi();

    public Employee(String n, int exp, int sal) {
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }

    public Employee(String n) {
        this.name = n;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void sayHi() {
        System.out.println("hi from " + name);
    }

    @Override
    public String toString() {
        return "Programmer " + "[name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }

    public void setSupervisee(Employee yindee) {
    }

    public void showSupervisee() {
    }

    public char[] getSupervisorName() {
        return null;
    }
}
