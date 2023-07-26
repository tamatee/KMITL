package comSci.Lab6;

public class Lab6 {
    public static void main(String[] args) {
        // char[] labels = { 'a', 'b', 'c', 'd' };
        int[] val = { 20, 30, 50, 10 };
        int[] weights = { 2, 5, 10, 5 };
        int C = 16;
        int sumV = 0;
        int sumW = 0;
        double[] perW = new double[4]; 
        // boolean[] isPicked = new boolean[4];
        //default value of boolean array is "false"
        // System.out.println(Arrays.toString(isPicked));
        for (int i = 0 ; i < val.length ; i++){
            perW[i] = (double) val[i] / weights[i];
        }
        int k = 0;
        while (sumW < C && ((sumW + weights[k]) < C)) 
        { /* Q2 */
            sumW += weights[k];
            sumV += val[k];
            k++; 
            System.out.println("sum value is "
                + sumV + " sum weight is " + sumW); 
        }
    }   
}