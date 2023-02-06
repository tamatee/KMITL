package packA;

public class Lab3EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;

    public Lab3EmpTmp(String n, int exp, int sal) {
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }

    public Lab3EmpTmp(String n) {
        this.name = n;
    }

    public Lab3EmpTmp() {

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
}