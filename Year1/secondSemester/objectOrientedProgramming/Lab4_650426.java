package objectOrientedProgramming;

import objectOrientedProgramming.packA.Employee;
import objectOrientedProgramming.packA.Programmer;
import objectOrientedProgramming.packA.ProgrammerManager;
import java.util.ArrayList;

public class Lab4_650426 {
    public static void main(String[] args) {
        q1();
        System.out.println("-------------------");
        q2();
    }

    static void q1() {
        ProgrammerManager manager = new ProgrammerManager("CodeReviewer", 9, 550);
        System.out.println(manager);
        ((Employee) manager).sayHi();
    }

    static void q2() {
        ProgrammerManager manager = new ProgrammerManager("CodeReviewer", 9, 550);
        ArrayList<Programmer> aList = new ArrayList<>();
        aList.add(new Programmer("Ken", 2, 300));
        aList.add(new Programmer("Isomeric", 3, 400));
        aList.add(new Programmer("haha", 4, 600));
        for (Programmer p : aList) {
            int newSalary = manager.evaluate(p);
            System.out.println(newSalary);
        }
    }
}
