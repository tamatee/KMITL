package proFun.Lab8o;
import java.util.Scanner;
public class Lab8Q2_65426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int [] firstArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i : firstArray) {
            if(firstArray[i] == 0){
                firstArray[i] = sc.nextInt();
            }
        }
        sc.close();
    }
}
