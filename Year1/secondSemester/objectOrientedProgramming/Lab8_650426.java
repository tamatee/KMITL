import java.util.List;
import java.util.function.Consumer;

import pack8A.*;
import java.util.*;

public class Lab8_650426 {
    static List<Singer> singerList = Arrays.asList(new Singer("Aba", "POP"), new Singer("Abi", "ROCK"), new Singer("Abo", "POP"),
            new Singer("Abe", "ROCK"));

    public static void main(String[] args) {
        q1_halfEachNumber();
        q2_forEachSingerName();
        q3_lambda_comparator();
        q4_method_reference_comparator();
    }

    public static void q1_halfEachNumber() {
        System.out.println("-".repeat(8));
        List<Integer> nums = Arrays.asList(100, 105);
        // 1.1
        HalfValueInterface halfVal = (n) -> System.out.println(n / 2);
        for (int n : nums) {
            halfVal.printHalf(n);
        }
        // 1.2
        Consumer<Integer> consumer = n -> System.out.println(n / 2);
        for (int n : nums) {
            consumer.accept(n);
        }
        // 1.3
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.forEach(halfMe);
        // 1.4
        nums.forEach(System.out::println);
        // 1.5
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::printHalf);
    }

    // 2.0
    public static void q2_forEachSingerName() {
        System.out.println("-".repeat(8));
        // 2.1
        singerList.stream().map(s -> s.getName())
                .forEach(System.out::println);
        // 2.2
        singerList.stream().map(Singer::getName)
                .forEach(System.out::println);
    }
    // 3.0
    public static void q3_lambda_comparator() {
        System.out.println("-".repeat(8));
        Comparator<Singer> byStyle1 = new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            }
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);
        // 3.1
        Comparator<Singer> byStyle2 = (p, q) -> p.getName().compareTo(q.getName());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);
    }
    // 4.0
    public static void q4_method_reference_comparator() {
        System.out.println("-".repeat(8));
        // 4.1
        Comparator<Singer> byName = Comparator.comparing(Singer::getName);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);
        System.out.println("-".repeat(8));
        // 4.2
        singerList.sort((a, b) -> a.getStyle().compareTo(b.getStyle()));
        singerList.forEach(System.out::println);
    }

}