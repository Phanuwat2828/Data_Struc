package stack;

import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String greeting = sc.nextLine();
        Pre_Post_Algorithm pe_po = new Pre_Post_Algorithm(greeting);
        System.out.println("PreFix : " + pe_po.Prefix());
        System.out.println("PostFix : " + pe_po.Postfix());
    }
}

class Pre_Post_Algorithm {
    public int top = -1;
    public int N = 0;
    public String stack_of_operator[];
    public String ans = "";
    public String greeting = "";

    public Pre_Post_Algorithm(String value) {
        this.N = value.length();
        this.greeting = value;
        this.stack_of_operator = new String[N];
    }

    public String Postfix() {
        this.ans = "";
        for (int i = 0; i < N; i++) {
            char text = greeting.charAt(i);
            if (Character.isLetter(text)) {
                this.ans += text;
            } else if (text == '(') {
                push(Character.toString(text));
            } else if (text == ')') {
                while (top > -1 && !stack_of_operator[top].equals("(")) {
                    this.ans += pop();
                }
                pop();
            } else {
                while (top > -1
                        && check_precedence(Character.toString(text)) <= check_precedence(stack_of_operator[top])) {
                    this.ans += pop();
                }
                push(Character.toString(text));
            }
        }
        while (top > -1) {
            this.ans += pop();
        }
        return this.ans;
    }

    public String Prefix() {
        this.ans = "";
        String reversedGreeting = new StringBuilder(greeting).reverse().toString();
        for (int i = 0; i < N; i++) {
            char text = reversedGreeting.charAt(i);
            if (Character.isLetter(text)) {
                this.ans = text + this.ans;
            } else if (text == ')') {
                push(Character.toString(text));
            } else if (text == '(') {
                while (top > -1 && !stack_of_operator[top].equals(")")) {
                    this.ans = pop() + this.ans;
                }
                pop();
            } else {
                while (top > -1
                        && check_precedence(Character.toString(text)) < check_precedence(stack_of_operator[top])) {
                    this.ans = pop() + this.ans;
                }
                push(Character.toString(text));
            }
        }
        while (top > -1) {
            this.ans = pop() + this.ans;
        }

        return this.ans;
    }

    public void push(String x) {
        if (this.top == this.N - 1) {
            System.out.println("Stack Overflow");
        } else {
            this.top++;
            stack_of_operator[this.top] = x;
        }
    }

    public String pop() {
        if (this.top == -1) {
            System.out.println("Stack Underflow");
            return "-1";
        } else {
            String x = stack_of_operator[this.top];
            this.top--;
            return x;
        }
    }

    public int check_precedence(String x) {
        if (x.equals("+") || x.equals("-")) {
            return 1;
        } else if (x.equals("*") || x.equals("/")) {
            return 2;
        } else if (x.equals("^")) {
            return 3;
        } else {
            return 0;
        }
    }
}
