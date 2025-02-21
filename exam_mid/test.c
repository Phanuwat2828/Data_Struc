import java.util.Scanner;
import java.util.ArrayList;

class Main {

    static class Node {
        int data;
        Node LLink;
        Node RLink;

        public Node(int data) {
            this.data = data;
            this.LLink = null;
            this.RLink = null;
        }
    }

    private static Node head = null;
    private static Node last = null;

    public static void add2Left(Node p, int data) {
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

    public static void add2Right(Node p, int data) {
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

    public static void printList() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.RLink;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // รับค่าจากผู้ใช้และเก็บไว้ใน ArrayList
        ArrayList<Integer> inputValues = new ArrayList<>();
        inputValues.add(sc.nextInt());
        inputValues.add(sc.nextInt());
        inputValues.add(sc.nextInt());
        inputValues.add(sc.nextInt());
        inputValues.add(sc.nextInt());

        // สร้าง node แรกจากค่าที่รับ
        Node p = new Node(inputValues.get(0));
        head = last = p;

        // แสดงผลทุกครั้งหลังจากเพิ่มค่า
        printList(); // แสดงผลหลังจากเพิ่ม node แรก

        // เพิ่มค่าในตำแหน่งต่างๆ ตามลำดับที่เก็บไว้ใน ArrayList
        for (int i = 1; i < inputValues.size(); i++) {
            if (i % 2 == 1) {  // ค่าที่เพิ่มเป็นค่าทางซ้าย
                add2Left(p, inputValues.get(i));
            } else {  // ค่าที่เพิ่มเป็นค่าทางขวา
                add2Right(p, inputValues.get(i));
            }
            printList();  // แสดงผลหลังจากเพิ่มค่าทุกครั้ง
        }

        sc.close();
    }
}