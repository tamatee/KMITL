package CodeArcade2023;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int d = scanner.nextInt();
        int v = scanner.nextInt();
        int g = scanner.nextInt();
        int r = scanner.nextInt();

        scanner.close();
        int p_time = d / v;
        int cnt = 0;
        while (p_time > (g + r)) {
            p_time -= (g + r);
            cnt++;
        }

        if (p_time < g ) {
            System.out.printf("%.8f\n",1.0 * l / v);
        }

        else {
            System.out.printf("%.8f\n", (l - d) * 1.0 / v + (cnt + 1) * (g + r));
        }

    }
}