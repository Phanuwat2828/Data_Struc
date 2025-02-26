package Tree;


class Node {
    int data;
    Node left, right;
    Node(int data){
        this.left = null;
        this.right = null;
        this.data = data;
    }

    void binaryTree(Node node,int value){
        Node p = new Node(value);
        if(node == null){
            node = p;
            return;
        }
        Node temp = node;
        Node prev = null;
        while(temp != null){
            prev = temp;
            if(value < temp.data){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        if(p.data < prev.data){
            prev.left = p;
        }else{
            prev.right = p;
        }

    }

    void PreOrder(Node root){
        if(root!=null){
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    void InOrder(Node root){
        if(root!=null){
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }

    void PostOrder(Node root){
        if(root!=null){
            InOrder(root.left);
            InOrder(root.right);
            System.out.print(root.data + " ");
           
        }
    }
}

public class Tree_str {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.binaryTree(root,9);
        root.binaryTree(root,-2);
        root.binaryTree(root,10);
        root.binaryTree(root,20);
        root.binaryTree(root,19);
        root.binaryTree(root,30);
        System.out.print("PreOrder: ");
        root.PreOrder(root);
        System.out.println();
        System.out.print("InOrder: ");
        root.InOrder(root);
        System.out.println();
        System.out.print("PostOrder: ");
        root.PostOrder(root);   
        System.out.println();
    }
}
