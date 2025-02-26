package exam5;

import java.util.Scanner;

class Node {
    String data;
    Node LLink, RLink;

    public Node(String data) {
        this.data = data;
        this.LLink = null;
        this.RLink = null;
    }
}

public class test {
    private Node head = null;
    private Node last = null;
    private Node current = null; // ใช้ติดตามตำแหน่งปัจจุบัน

    public void add2Right(String data) {
        Node Q = new Node(data);

        if (head == null) {
            head = last = current = Q;
            return;
        }

        Q.LLink = current;
        if (current.RLink != null) {
            Q.RLink = current.RLink;
            current.RLink.LLink = Q;
        } else {
            last = Q; // ถ้าเพิ่มท้ายสุด ต้องอัปเดต last
        }

        current.RLink = Q;
        current = Q; // เลื่อนไปที่โหนดใหม่
    }

    public String show_B() {
        if (current == null || current.LLink == null) return " ";
        current = current.LLink;
        return current.data;
    }

    public String show_F() {
        if (current == null || current.RLink == null) return " ";
        current = current.RLink;
        return current.data;
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
        int caseNum = 0;

        while (true) {
            caseNum++;
            int count = sc.nextInt();
            sc.nextLine();
            if (count == 0) break;

            System.out.println("Case_" + caseNum);
            test list = new test();

            for (int i = 0; i < count; i++) {
                String data = sc.nextLine();
                if (data.equals("B")) {
                    System.out.println(list.show_B());
                } else if (data.equals("F")) {
                    System.out.println(list.show_F());
                } else {
                    list.add2Right(data);
                }
            }
        }
        sc.close();
    }
}
