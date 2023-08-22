package DSA.lab4;

public class Question3 {
    public static void main(String[] args) {
//        rotate linkedList example 1 > 2 > 3 > 4 > 5 to ans: 3 > 4 > 5 > 1 > 2
        MyLinkedList L3 = new MyLinkedList();
        L3.add(1);
        L3.add(2);
        L3.add(3);
        L3.add(4);
        L3.add(5);
        L3.rotate(3);
        System.out.println(L3.toString());
    }
}
