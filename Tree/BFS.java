import java.util.HashMap;
import java.util.Map;

class MyLinkedList {
    private Node head;

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public String remove() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public void delete(String data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Node with data " + data + " not found");
    }
}

class MyQueue {
    private MyLinkedList list;

    public MyQueue() {
        list = new MyLinkedList();
    }

    public void enqueue(String data) {
        list.add(data);
    }

    public String dequeue() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        list.display();
    }
}

class Graph {
    private Map<String, MyLinkedList> adjList; // เปลี่ยนเป็น Map สำหรับเก็บ vertex ที่เป็นชื่อ

    Graph() {
        adjList = new HashMap<>();
    }

    // เพิ่ม vertex ใหม่
    public void addVertex(String vertex) {
        adjList.put(vertex, new MyLinkedList());
    }

    void addEdge(String v, String w) {
        if (!adjList.containsKey(v)) {
            addVertex(v);
        }
        if (!adjList.containsKey(w)) {
            addVertex(w);
        }
        adjList.get(v).add(w);
    }

    void deleteEdge(String v, String w) {
        if (adjList.containsKey(v)) {
            adjList.get(v).delete(w);
        }
    }

    void BFS(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Vertex not found.");
            return;
        }

        Map<String, Boolean> visited = new HashMap<>();
        MyQueue queue = new MyQueue();

        visited.put(start, true);
        queue.enqueue(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            String node = queue.dequeue();
            System.out.print(node + " ");

            MyLinkedList.Node current = adjList.get(node).getHead();
            while (current != null) {
                String neighbor = current.data;
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, true);
                    queue.enqueue(neighbor);
                }
                current = current.next;
            }
        }
        System.out.println();
    }
}

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");

        System.out.println("Before deleting edge A-B:");
        graph.BFS("A");

        graph.deleteEdge("A", "B");

        System.out.println("After deleting edge A-B:");
        graph.BFS("A");

        graph.addVertex("E");
        graph.addEdge("E", "A");
        graph.addEdge("E", "B");

        System.out.println("After adding vertex E and adding edges:");
        graph.BFS("A");
    }
}
