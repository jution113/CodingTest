import java.util.*;
import java.io.*;

class Solution {
    private static final int T = 10;
    
    private static HashMap<Integer, Node> nodeMap;
    private static ArrayDeque<Integer> stack;
    
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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
		for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            nodeMap = new HashMap<> ();
            stack = new ArrayDeque<> ();
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                String val = st.nextToken();
                int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
                int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
                nodeMap.put(id, new Node(val, left, right));
            }
            
            int answer = validate(1) ? 1 : 0;
            sb.append("#" + t + " " + answer + "\n");
		}
        System.out.println(sb.toString());
	}
    
    private static boolean validate(int start) {
        Node node = nodeMap.get(start);
        
        if (node.left != -1 && !validate(node.left)) return false;
        if (node.right != -1&& !validate(node.right)) return false;
        if (isOperator(node.val)) {
            if (stack.size() < 2) return false;
            stack.pop();
        } else {
            stack.push(1);
        }
        return true;
    }
    
    private static boolean isOperator(String str) {
        char c = str.charAt(0);
        return c == '*' || c == '/' || c == '+' || c == '-';
    }
}