import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] inOrder = new int[n];
        int[] postOrder = new int[n];

        StringTokenizer inOrderSt = new StringTokenizer(br.readLine());
        StringTokenizer postOrderSt = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(inOrderSt.nextToken());
            postOrder[i] = Integer.parseInt(postOrderSt.nextToken());
        }

        Node root = rebuildTree(inOrder, postOrder);
        preOrderTraversal(root); 

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            sb.append(" ");
        }

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

    static Node rebuildTree(int[] inOrder, int[] postOrder) {
        return recurRebuildTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
    }
    
    static Node recurRebuildTree(int[] inOrder, int inOrderStartIdx, int inOrderEndIdx, int[] postOrder, int postOrderStartIdx, int postOrderEndIdx) {
        if(inOrderStartIdx > inOrderEndIdx || postOrderStartIdx > postOrderEndIdx) return null;
    
        int rootData = postOrder[postOrderEndIdx];
        int inOrderRootIdx = 0;
    
        // find root data from inOrder
        for(int i = inOrderStartIdx; i <= inOrderEndIdx; i++) {
            if(rootData == inOrder[i]) {
                inOrderRootIdx = i;
                break;
            }
        }

        Node node = new Node(inOrder[inOrderRootIdx]);
        int leftSubTreeSize = inOrderRootIdx - inOrderStartIdx;
    
        // left node
        node.left = recurRebuildTree(inOrder, inOrderStartIdx, inOrderRootIdx - 1, postOrder, postOrderStartIdx, postOrderStartIdx + leftSubTreeSize - 1);
    
        // right node
        node.right = recurRebuildTree(inOrder, inOrderRootIdx + 1, inOrderEndIdx, postOrder, postOrderStartIdx + leftSubTreeSize, postOrderEndIdx - 1);
        
        return node;
    }
    
    static void preOrderTraversal(Node node) {
        result.add(node.data);
    
        if(node.left != null) {
            preOrderTraversal(node.left);
        }
    
        if(node.right != null) {
            preOrderTraversal(node.right);
        }
    }
}