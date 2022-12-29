package proFun.Lab4o;

import java.util.Scanner;

public class Lab4Q2_650426 {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input : ");
    int x = sc.nextInt();
    int sum = 0;
    while (x > 0) {
        x += sum;
        x = sc.nextInt();
    }
    System.out.println(sum);
    sc.close();
   } 
}
