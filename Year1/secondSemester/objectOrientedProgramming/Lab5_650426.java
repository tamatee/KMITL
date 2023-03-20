import packA.ArrayProcessor;
import java.util.*;
import java.util.stream.*;

public class Lab5_650426 {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n/2th element of sorted = 48

    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }

    public static void q1() {
        q1NumberOfEvenElement = (arr) -> (int)Arrays.stream(arr).filter(i -> i%2 == 0).count();
        System.out.println(q1NumberOfEvenElement.calculate(data));
    }

    public static void q2() {
        q2IndexOfLargestEvenValue = (arr) -> IntStream.range(0, arr.length).filter(i -> arr[i] == Arrays.stream(arr).filter(n -> n%2 == 0).max().getAsInt()).findFirst().orElse(-1);
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        myMedian = (calculate) -> {
            double d = (double) tmp.length / 2;
            return tmp[(int) Math.ceil(d)];
        };
        System.out.println(myMedian.calculate(tmp)); // 48
    }
}
