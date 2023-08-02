package CodeArcade2023;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int d = scanner.nextInt();
        int v = scanner.nextInt();
        int g = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.close();
        double timeToTrafficLights = 1.0 * d / v;
        int cyclesCompleted = (int) (timeToTrafficLights / (g + r));
        int time = ( cyclesCompleted / v ) % ( g + r );
        if (time < g)
            System.out.printf("%.12f\n",1.0*l/v);
        else
            System.out.printf("%.12f\n",cyclesCompleted - time + g + r + 1.0 * ( l - d ) / v);
    }
}