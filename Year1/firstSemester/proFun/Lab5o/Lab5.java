package proFun.Lab5o;
import java.util.Scanner;
public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("ใส่จำนวนพุ่ม: ");
        int n = scan.nextInt();
        for (int star = 1; star <= n; star++) { // ทำพุ่ม
            for (int row = star; row <= star + 3; row++) { // ทำแถว
                for (int space = 1; space <= (n + 3) - row; space++) { // ทำช่องว่าง
                    System.out.print(" ");
                }
                for (int col = 1; col <= row * 2 - 1; col++) { // ทำ *
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        for (int starT = 1; starT <= n; starT++) { // ทำลำต้น
            for (int space = 1; space <= n + 1; space++) { // ทำช่องว่าง
                System.out.print(" ");
            }
            System.out.print("***"); // ส่วนของลำต้น
            System.out.println();
        }
        scan.close();
    }
}