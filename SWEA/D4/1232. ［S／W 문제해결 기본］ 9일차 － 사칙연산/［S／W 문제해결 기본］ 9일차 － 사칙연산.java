import java.util.*;
import java.io.*;

class Solution {
    private static final int T = 10;
    
    private static HashMap<Integer, Node> nodeMap;
    
    private static class Node {
        String val;
        int left;
        int right;
        
        public Node(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		for(int t = 1; t <= T; t++) {
            int n =Integer.parseInt(br.readLine());
            nodeMap = new HashMap<> ();
            
            for (int i = 0; i < n; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int id = Integer.parseInt(st.nextToken());
                String val = st.nextToken();
                int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
                int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
                
                nodeMap.put(id, new Node(val, left, right));
            }
            
            ArrayDeque<Integer> st = new ArrayDeque<> ();
            postorder(1, st);
            sb.append("#" + t + " " + st.pop() +"\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void postorder(int id, ArrayDeque<Integer> st) {
        Node node = nodeMap.get(id);
        
        if (node.left != -1) postorder(node.left, st);
        if (node.right != -1) postorder(node.right, st);
        if (isOperator((node.val.charAt(0)))) {
            int b = st.pop();
            int a = st.pop();
            st.push(calculate(a, b, node.val.charAt(0)));
        } else {
        	st.push(Integer.parseInt(node.val));
        }
    }
    
    private static boolean isOperator(char c) {
        return c - '0' < 0 || c - '0' > 9; 
    }
    
    private static Integer calculate(int a, int b, char op) {
        switch (op) {
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '+':
                return a + b;
            case '-':
                return a - b;
        }
        return -1;
    }
}