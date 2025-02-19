package example;
import java.util.Queue;

public class program3 {
    public static void main(String[] args) {
        int value = 0;
        Circular obj = new Circular(3);
        obj.clearq();
        obj.enq(10);
        obj.enq(5);
        obj.enq(20);
        obj.printq();
        obj.enq(30);
        value = obj.deq();
        obj.printq();
        obj.enq(50);
        obj.printq();
        value = obj.deq();
        obj.printq();
        value = obj.deq();
        obj.printq();
    }
}

class Circular{
    private int size;
    private int cirq[];
    private int r,f;
    public Circular(int max){
        size  = max;
        cirq = new int[max];
    } 
    public void clearq(){
        f=r-1;
    }
    public boolean isFull(){
        return f==(r+1)%size;
    }
    public boolean isEmpty(){
        return f==-1;
    }
    public void enq(int value){
        if(isFull()){
            System.out.println("Queue is Full");
        }else{
            if(isEmpty()){
                f = r=0;

            }else{
                r=(r+1)%size;
            }
            cirq[r] = value;
        }
    }
    public int deq(){
        int value = -99;
        if(isEmpty()){
            System.out.println("Queue is Empty");

        }else{
            value = cirq[f];
            if(f==r){
                f=r=-1;
            }else{
                f=(f+1)%size;
            }
        }
        return value;
    }
    public void printq(){
        int  i=0;
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }else if(f<=r){
            for(i=f;i<=r;i++){
                System.out.print(cirq[i]+" ");
            }
        }else{
            for(i=f;i<size;i++){
                System.out.print(cirq[i]+ " ");
            }
            for(i=0;i<=r;i++){
                System.out.print(cirq[i]+" ");
            }
        }
        System.out.println(" ");
    }

}
