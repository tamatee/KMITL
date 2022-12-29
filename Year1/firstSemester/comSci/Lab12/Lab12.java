package Lab12;

public class Lab12 {
    public static void main(String[] args) {
        int C = 16;
        int[] itemsW = { 2, 10, 5, 5 };
        int[] itemsV = { 20, 50, 30, 10 };
        int[][] table = new int[itemsW.length + 1][C + 1];
        int item = 0;
        int weightSoFar = 0;
        int curWeight = 0;
        int curValue = 0;
        // initialize row0 and col0 to zero (omitted here)
        for (item = 1; item <= itemsW.length; item++) {
            for (weightSoFar = 0; weightSoFar <= C; weightSoFar++) {
                curWeight = itemsW[item - 1];
                curValue = itemsV[item - 1];
                table[item][weightSoFar] = table[item - 1][weightSoFar];
                if (weightSoFar - curWeight >= 0) {
                    if (curValue + table[item - 1][weightSoFar
                            - curWeight] > table[item - 1][weightSoFar]) {
                        table[item][weightSoFar] = curValue +
                                table[item - 1][weightSoFar - curWeight];
                    }
                }
                // else println("negative index");
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }
    }
}
