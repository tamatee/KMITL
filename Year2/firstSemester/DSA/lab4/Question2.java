package DSA.lab4;

public class Question2 {
    public static void main(String[] args) {
//        rotate linkedList example 1 > 2 > 3 > 4 > 5 to ans: 3 > 4 > 5 > 1 > 2
        MyLinkedList L2 = new MyLinkedList();
        L2.add(1);
        L2.add(2);
        L2.add(3);
        L2.add(4);
        L2.add(5);
        L2.rotate(3);
        System.out.println(L2.toString());
    }
}
