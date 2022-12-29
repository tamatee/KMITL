package proFun.Lab4o;

import java.util.*;

public class Lab4Q1_650426{
    public static double ftoc(double f) {
     double c = ((f-32) / 9) * 5;   
     return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Temp. (F): ");
        double f = sc.nextDouble();
        sc.close();
        // C/5 == (F-32) / 9
        System.out.printf("%.2f\n", ftoc(f));
    }
}
