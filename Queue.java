import exam_mid.Circular;

public class Queue {
    public static String exam = "+*123";
    
    public static void main(String args[]){
        Circular queue = new Circular(100);
        queue.enq(10);
        queue.enq(20);
        queue.enq(30);
        queue.enq(40);
        queue.deq();
        queue.enq(50);
        queue.printq();        
    }
}

class Circular {
    private int size;
    private int cirq[];
    private int r, f;
    
    public Circular(int max) {
        size = max;
        cirq = new int[max];
        f = r = -1;
    }
    
    public void clearq() {
        f = r = -1;
    }
    
    public boolean isFull() {
        return f == (r + 1) % size;
    }
    
    public boolean isEmpty() {
        return f == -1;
    }
    
    public void enq(int value) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (isEmpty()) {
                f = r = 0;
            } else {
                r = (r + 1) % size;
            }
            cirq[r] = value;
        }
    }
    
    public int deq() {
        int value = -99;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            value = cirq[f];
            if (f == r) {
                f = r = -1;
            } else {
                f = (f + 1) % size;
            }
        }
        return value;
    }
    
    public void printq() {
        int i = 0;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else if (f <= r) {
            for (i = f; i <= r; i++) {
                if(i==r){
                    System.out.print(cirq[i]);
                }else{
                    System.out.print(cirq[i]+ " ");
                }
            }
        } else {
            for (i = f; i < size; i++) {
                System.out.print(cirq[i] + " ");
            }
            for (i = 0; i <= r; i++) {
                if(i==r){
                    System.out.print(cirq[i]);
                }else{
                    System.out.print(cirq[i]+ " ");
                }
                
            }
        }
        System.out.println("Tes");
    }
}
