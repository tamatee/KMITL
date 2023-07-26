package objectOrientedProgramming.packA;
import java.util.ArrayList;

public class ProgrammerManager extends Programmer implements ManagerRoles {
   ArrayList<String> c = new ArrayList<>();
   public ProgrammerManager() {
   }
   public ProgrammerManager(String name, int exp, int sal) {
      super(name, exp, sal);
   }
   public void sayHi() {
      c.add("solidity");
      c.add("typescript");
      System.out.println("Coding in" + c);
   }
   public String coding() {
      return String.format("ManagerProgermmer %s", super.toString());
   }
   public int evaluate(Programmer p) {
      p.salary += p.getSalary()/10 + p.getSalary()/20;
      return p.getSalary();
   }
}
