package round0;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        sc.close();
        if (score >= 90)    System.out.println("A");
        else if (score >= 85)   System.out.println("B+");
        else if (score >= 75)   System.out.println("B");
        else if (score >= 65)   System.out.println("C+");
        else if (score >= 55)   System.out.println("C");
        else if (score >= 45)   System.out.println("D+");
        else if (score >= 40)   System.out.println("D");
        else    System.out.println("F");
    }
}