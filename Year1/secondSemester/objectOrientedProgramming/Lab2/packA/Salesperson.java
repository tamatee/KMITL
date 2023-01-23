package packA;

public class Salesperson extends Programmer{
    private int target;
    public Salesperson(String n, int sal, int exp, int assignedTarget) {
       super(n, sal, exp);
        this.target = assignedTarget;
    }
    public Salesperson(String n, int exp){

    }
    public void setTarget(int target) {
        this.target = target;
    }
    public int getTarget() {
        return target;
    }
    public void setSalary() {
        salary += (salary/10);
        super.setSalary(salary);
    }
    @Override
    public void setSalary(int incresedAmount) {
        super.setSalary(salary + incresedAmount);
    }
    public String makeQuotation() {
        return String.format("Dear value customer, %.0f is my best offer.", Math.random() * target);
    }
    @Override
    public String toString() {
        return "Salesperson " + "[target=" + target+ " " + super.toString() + " ]"; 
    }
}
