
class StackNode {
    Node data;
    StackNode next;

    public StackNode(Node data) {
        this.data = data;
        this.next = null;
    }
}

class MyStack {
    private StackNode top;

    public MyStack() {
        this.top = null;
    }

    public void push(Node data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Node temp = top.data;
        top = top.next;
        return temp;
    }

    public Node peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class ExpressionTree {
    public static boolean isOperator(String c) {
        return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
    }

    public static Node constructTree(String postfix) {
        MyStack stack = new MyStack();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            Node node = new Node(token);

            if (isOperator(token)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }

            stack.push(node);
        }
        return stack.peek();
    }

    public static double evaluate(Node root) {
        if (root == null)
            return 0;

        if (!isOperator(root.data)) {
            return Double.parseDouble(root.data);
        }

        double leftValue = evaluate(root.left);
        double rightValue = evaluate(root.right);

        switch (root.data) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
        }
        return 0;
    }

    public static String infixToPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        MyStack stack = new MyStack();
        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                output.append(ch);
            } else {
                output.append(" ");
                while (!stack.isEmpty() && precedence(stack.peek().data) >= precedence(Character.toString(ch))) {
                    output.append(stack.pop().data).append(" ");
                }
                stack.push(new Node(Character.toString(ch)));
            }
        }
        while (!stack.isEmpty()) {
            output.append(" ").append(stack.pop().data);
        }
        return output.toString();
    }

    private static int precedence(String ch) {
        if (ch.equals("+") || ch.equals("-"))
            return 1;
        if (ch.equals("*") || ch.equals("/"))
            return 2;
        return 0;
    }
}

public class result {
    public static void main(String[] args) {
        String infix = "34+5*40-20/5*10";
        String postfix = ExpressionTree.infixToPostfix(infix);
        System.out.println("Postfix: " + postfix);
        Node root = ExpressionTree.constructTree(postfix);
        double result = ExpressionTree.evaluate(root);
        System.out.println("Result: " + result);

    }
}
