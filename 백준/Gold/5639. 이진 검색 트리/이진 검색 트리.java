import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BinarySearchTree tree = new BinarySearchTree();

        String input;
        while((input = br.readLine()) != null && !input.equals("")) {
            int data = Integer.parseInt(input);
            
            tree.insertNode(new Node(data));
        }

        tree.postOrder(tree.root, sb);
        System.out.print(sb);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BinarySearchTree {
        Node root;

        void insertNode(Node node) {
            if(root == null) {
                root = node;
                return;
            }

            Node parent = root;

            while(true) {
                if(node.data < parent.data) {
                    if(parent.left == null) {
                        parent.left = node;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if(parent.right == null) {
                        parent.right = node;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        void postOrder(Node startNode, StringBuilder sb) {
            if(startNode.left != null) postOrder(startNode.left, sb);
            if(startNode.right != null) postOrder(startNode.right, sb);
            sb.append(startNode.data).append('\n');
        }
    }
}