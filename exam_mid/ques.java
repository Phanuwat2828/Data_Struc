public class ques {
    public static String exam = "+*123";
    
    public static void main(String args[]){
        Circular queue = new Circular(100);
        String reversedExam = "";
        String number ="";
        String operator = "";
        for(int i=0;i<exam.length();i++){
            if(Character.isDigit(exam.charAt(i))){
                number+=Character.toString(exam.charAt(i));
            }else{
                operator+=Character.toString(exam.charAt(i));
            }
        }
        number = new StringBuilder(number).reverse().toString();
        number+=operator;
        reversedExam = number;
        System.out.println(reversedExam);
        for (char ch : reversedExam.toCharArray()) {
            if (Character.isDigit(ch)) {
                queue.enq(Character.getNumericValue(ch));
            } else {
                int operand1 = queue.deq();
                int operand2 = queue.deq();
                int result = 0;
                System.out.println(operand1+" "+ch+" "+" "+operand2);
                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }
                queue.enq(result);
            }
        }
        
        System.out.println("Result of prefix evaluation: " + queue.deq());
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
                System.out.print(cirq[i] + " ");
            }
        } else {
            for (i = f; i < size; i++) {
                System.out.print(cirq[i] + " ");
            }
            for (i = 0; i <= r; i++) {
                System.out.print(cirq[i] + " ");
            }
        }
        System.out.println(" ");
    }
}
