import java.util.HashMap;
import java.util.Map;

class MyStack_ {
    private int maxSize;
    private int top;
    private String[] stackArray;

    public MyStack_(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(String value) {
        if (!isFull()) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full. Cannot push.");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }
}

class MyLinkedList1 {
    Node head;

    class Node {
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

    public void delete(String data) {
        if (head == null)
            return;

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public Node getHead() {
        return head;
    }
}

class Graph {
    private Map<String, MyLinkedList1> adjList;

    Graph() {
        adjList = new HashMap<>();
    }

    void addEdge(String v, String w) {
        if (!adjList.containsKey(v)) {
            adjList.put(v, new MyLinkedList1());
        }
        if (!adjList.containsKey(w)) {
            adjList.put(w, new MyLinkedList1());
        }
        adjList.get(v).add(w);
    }

    void deleteEdge(String v, String w) {
        if (adjList.containsKey(v)) {
            adjList.get(v).delete(w);
        }
    }

    void DFS(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Vertex not found.");
            return;
        }
        Map<String, Boolean> visited = new HashMap<>();
        MyStack_ stack = new MyStack_(adjList.size());
        visited.put(start, true);
        stack.push(start);
        System.out.print("DFS Traversal: ");
        while (!stack.isEmpty()) {
            String node = stack.pop();
            System.out.print(node + " ");
            MyLinkedList1.Node current = adjList.get(node).getHead();
            while (current != null) {
                String neighbor = current.data;
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, true);
                    stack.push(neighbor);
                }
                current = current.next;
            }
        }
        System.out.println();
    }
}

public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");

        System.out.println("DFS Traversal from node A:");
        graph.DFS("A");

        graph.deleteEdge("A", "B");

        System.out.println("DFS Traversal from node A after deleting edge A-B:");
        graph.DFS("C");
    }
}
