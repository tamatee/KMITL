package proFun.Lab7o;
/**
 * Lab7Q1_65426
 */
public class Lab7Q1_65426 {

    public static void main(String[] args) {
        int n = 5;
        factorial(n);
    }
    static int factorial(int n){
        int solution = 1;
        for (int i = 1; i < n+1; i++) {
            solution = solution * i;
            System.out.println(solution);
        }
        return 0;
    }
}