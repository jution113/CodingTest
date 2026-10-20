import java.util.*;
import java.io.*;

class Solution {
	private static int T = 10;

    private static HashMap<Integer, Node> nodeMap;
    
    private static class Node {
        char c;
        int left;
        int right;
        
        public Node(char c, int left, int right) {
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        
		for(int t = 1; t <= T; t++) {
            nodeMap = new HashMap<> ();
            StringBuilder answer = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
                int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
                
                nodeMap.put(id, new Node(c, left, right));
            }
            
            inorder(1, answer);
            sb.append("#" + t + " " + answer.toString() + "\n");
		}
        
        System.out.println(sb.toString());
	}
    private static void inorder(int id, StringBuilder answer) {
        Node node = nodeMap.get(id);
            
        if (node.left != -1) inorder(node.left, answer);
        answer.append(node.c);
        if (node.right != -1) inorder(node.right, answer);
    }
}