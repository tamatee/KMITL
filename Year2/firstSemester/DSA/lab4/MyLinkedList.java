package DSA.lab4;

public class MyLinkedList {

    public class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
    }

    Node head = null;
    Node tail = null;

    public void add(int d) {
        Node p = new Node(d);
        if ( tail == null ) {
            head = p;
            tail = p;
        }
        else {
            tail.next = p;
            tail = p;
        }
    }

    public void insert(int d, Node p) {
        Node q = new Node(d);
        q.next = p.next;
        p.next = q;
    }

    public Node find(int d) {
        Node p = head;
        while ( p != null ) {
            if ( p.data == d ) return p;
            p = p.next;
        }
        return p;
    }

    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ( (p.next != null ) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    public void rotate(int k) {
        if (head == null || k <= 0) {
            return;
        }

        int length = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return;
        }

        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        current.next = head;
        head = newHead;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("head");
        Node p = head;

        while ( p != null ) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return  new String(sb);
    }
}
