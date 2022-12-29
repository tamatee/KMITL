/**
 * test
 */
public class test {

    public static void main(String [] args) {
        System.out.println(factorial(2));
    }
    public static int factorial(int n) {
        if (n == 0) return 1;
        else return n*factorial(n-1);
    }
}