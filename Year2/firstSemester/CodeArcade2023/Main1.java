package CodeArcade2023;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            char result = checkEquation(a, b, c);
            System.out.println(result);
        }

        scanner.close();
    }

    public static char checkEquation(int a, int b, int c) {
        if (a + b == c) {
            return '+';
        } else {
            return '-';
        }
    }
}

