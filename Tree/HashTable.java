package Tree;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList_ {
    private Node head;

    public LinkedList_() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class HashTable {
    private LinkedList_[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList_[size];
        for (int i = 0; i < size; i++)
            table[i] = new LinkedList_();
    }

    public void insert(int key) {
        int index = key % size;
        table[index].insert(key);
    }

    public boolean search(int key) {
        int index = key % size;
        return table[index].search(key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            table[i].display();
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(5);
        ht.insert(10);
        ht.insert(15);
        ht.insert(20);
        ht.insert(25);
        ht.display();

        if (ht.search(25)) {
            System.out.println("Found it");
        } else {
            System.out.println("Not Found");
        }
    }
}
