package DSA.lab3;

public class ArrayTester {
    public static void main(String[] args) {
        int N = 0x989680; //hex(10000000)
        while (N <= 0x5f5e100) { //hex(100000000)
            long start = System.currentTimeMillis();
            MyArray mArray = new MyArray();
            for (int n = 1; n < N; n++)
                if (!mArray.isFull()) mArray.add((int) (Math.random() * 0x3e8)); //hex(1000)
            long time = (System.currentTimeMillis() - start);
            System.out.println(N + " \t" + time);
            N += 0x989680; //hex(10000000)
        }
    }
}