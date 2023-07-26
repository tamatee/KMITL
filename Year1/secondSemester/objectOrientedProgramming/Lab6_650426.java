package objectOrientedProgramming;


import objectOrientedProgramming.packA.Client;
import objectOrientedProgramming.packA.Customer;

/**
 * Lab6_65050426
 */
public class Lab6_650426 {

    public static void main(String[] args) {
        q1();
        System.out.println("-".repeat(69));
        q2();
        System.out.println("-".repeat(69));
        q3();
    }
    public static void q1() {
        int[] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1};
        Customer yindee = new Customer("Yindee");
        int i = 0;
        for (; i < monthly.length; i++)
            yindee.spend(monthly[i]);
    }
    public static void q2() {
        int[] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1};
        Client preeda = new Client("Preeda");
        int i = 0;
        for (; i < monthly.length; i++)
            preeda.spend(monthly[i]);
    }
    public static void q3() {
//        MemberTypeWithDiscount p = MemberTypeWithDiscount.GOLD;
//        MemberTypeWithDiscount q = MemberTypeWithDiscount.GOLD;
//        System.out.println(p == q); //true ...why?
    }
}