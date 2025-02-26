
package exam5;

import java.util.Scanner;

class Node {
    String data;
    Node LLink;
    Node RLink;

    public Node(String data) {
        this.data = data;
        this.LLink = null;
        this.RLink = null;
    }
}

public class DoublyLinkedList {
    private Node head = null;
    private Node last = null;

    public void add2Left(Node p, String data) {
        Node Q = new Node(data);

        if (head == null) {
            head = last = Q;
            return;
        }

        if (p == head) {
            Q.RLink = p;
            p.LLink = Q;
            head = Q;
            return;
        }

        Q.LLink = p.LLink;
        Q.RLink = p;
        p.LLink.RLink = Q;
        p.LLink = Q;
    }

    public String show_B() {
        try {
            Node p = last;
            p = p.LLink;
            String data = p.data;
            if (data.equals("default")) {
                p = p.LLink;
            }
            return data;
        } catch (Exception e) {
            return " ";
        }

    }

    public String show_F() {
        try {
            Node p = last;
            p = p.RLink;
            return p.data;
        } catch (Exception e) {
            return " ";
        }

    }

    public void add2Right(Node p, String data) {
        Node Q = new Node(data);

        if (head == null) {
            head = last = Q;
            return;
        }

        if (p == last) {
            Q.LLink = p;
            p.RLink = Q;
            last = Q;
            return;
        }

        Q.RLink = p.RLink;
        Q.LLink = p;
        p.RLink.LLink = Q;
        p.RLink = Q;
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.RLink;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count_ = 0;

        while (true) {
            count_ += 1;
            DoublyLinkedList list = new DoublyLinkedList();
            int cout = sc.nextInt();
            sc.nextLine();
            Node p = new Node("default");
            if (cout == 0) {
                break;
            }

            System.out.println("Case_" + count_);
            for (int i = 0; i < cout; i++) {
                String data = sc.nextLine();

                if (data.equals("B")) {
                    System.out.println(list.show_B());
                } else if (data.equals("F")) {
                    System.out.println(list.show_F());
                } else {

                    if (list.head == null) {

                        p.LLink = null;
                        p.RLink = null;
                        list.head = list.last = p;
                    } else {

                    }
                    list.add2Right(p, data);
                }
            }
        }
    }
}
