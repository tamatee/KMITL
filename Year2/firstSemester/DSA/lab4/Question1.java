package DSA.lab4;

public class Question1 {
    public static void main(String[] args) {
//        rotate linkedList example 1 > 2 > 3 > 4 > 5 to ans: 3 > 4 > 5 > 1 > 2
        MyLinkedList L1 = new MyLinkedList();
        L1.add(1);
        L1.add(2);
        L1.add(3);
        L1.add(4);
        L1.add(5);
        L1.rotate(3);
        System.out.println(L1.toString());
    }
}
