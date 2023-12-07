import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        final char DEFAULT_ROOT = 'A';
        int nodeCnt = Integer.parseInt(br.readLine());

        ArrayList<Node> nodes = new ArrayList<>();
        Node root = new Node(DEFAULT_ROOT);
        nodes.add(root);

        for(int i = 0; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node leftNode = left == '.' ? null : new Node(left);
            Node rightNode = right == '.' ? null : new Node(right);
            
            for(int j = 0; j < nodes.size(); j++) {
                if(nodes.get(j).data == parent) {
                    if(leftNode != null) nodes.add(leftNode);
                    nodes.get(j).left = leftNode;
                    if(rightNode != null) nodes.add(rightNode);
                    nodes.get(j).right = rightNode;
                }
            }
        }
        
        preOrder(root, sb);
        sb.append('\n');
        inOrder(root, sb);
        sb.append('\n');
        postOrder(root, sb);

        System.out.println(sb);
    }

    static void preOrder(Node start, StringBuilder result) {
        if(start == null) return;
        result.append(start.data);
        if(start.left != null) preOrder(start.left, result);
        if(start.right != null) preOrder(start.right, result);
    }

    static void inOrder(Node start, StringBuilder result) {
        if(start == null) return;
        if(start.left != null) inOrder(start.left, result);
        result.append(start.data);
        if(start.right != null) inOrder(start.right, result);
    }

    static void postOrder(Node start, StringBuilder result) {
        if(start == null) return;
        if(start.left != null) postOrder(start.left, result);
        if(start.right != null) postOrder(start.right, result);
        result.append(start.data);
    }
}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }
}