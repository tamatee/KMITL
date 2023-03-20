import packA.*;

public class Lab2_650426 {
    public static void main(String[] args) {
        q1();
        q2_Salesperson();
        q3_Accountant();
    }

    static void q1() {
        Programmer p1 = new Programmer("ber1", 2, 500);
        System.out.println(p1); // Programmer [name=ber1, salary=500, experience=2]
    }

    static void q2_Salesperson() {
        Salesperson p2 = new Salesperson("mr.salesperson", 5, 150, 5000);
        Salesperson p3 = new Salesperson("mr.kayan", 4, 260, 9000);
        System.out.println("example of inherited method " + p2.getName());
        System.out.println(p2.makeQuotation());
        System.out.print("another example of inherited method ");
        p3.sayHi();
        System.out.println("notice the result of overridden setSalary(int incresedAmount) below");
        System.out.print(p2.getName() + "'s salary was " + p2.getSalary() + " -> ");
        p2.setSalary(100);
        System.out.println(p2);
        p2.setSalary();
        System.out.println(p2);
        System.out.println(p3);
        // example of inherited method mr.salesperson
        // Dear value customer, 898 is my best offer.
        // another example of inherited method hi from mr.kayan
        // notice the result of overridden setSalary(int incresedAmount) below
        // mr.salesperson's salary was 150 -> Salesperson [target=5000 Programmer
        // [name=mr.salesperson, salary=250, experience=5] ]
        // Salesperson [target=5000 Programmer [name=mr.salesperson, salary=275,
        // experience=5] ]
        // Salesperson [target=9000 Programmer [name=mr.kayan, salary=260, experience=4]
        // ]
    }

    static void q3_Accountant() {
        Accountant p4 = new Accountant("goodAtmyJob", 7, 6, 390, "sing");
        Accountant p5 = new Accountant("canRap", 4, 9, 480, "rap");
        System.out.println(p4.tellProfit());
        p5.sayHi();
        System.out.println(Accountant.tellMyRole());
        System.out.println(p4);
        System.out.println(p5);
        // berk barn jamkad's profit is 334. My salary is 390
        // canRap says hello
        // I am an accountant at berk barn jamkad
        // Accountant [experience=6, specialty=sing]
        // Accountant [experience=9, specialty=rap]
    }
}