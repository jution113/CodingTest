import java.util.*;
import java.io.*;

class Solution {
    private static Node[] nodes;
    
    private static class Node {
        int parent;
        ArrayList<Integer> children = new ArrayList<> ();
        
        private void addChild(int child) {
            children.add(child);
        }
    }
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            nodes = new Node[V + 1];
            for (int i = 1; i <= V; i++) nodes[i] = new Node();
            
	        st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
            	int parent = Integer.parseInt(st.nextToken());
            	int child = Integer.parseInt(st.nextToken());
                
                nodes[parent].addChild(child);
                nodes[child].parent = parent;
            }
            
            int nearestCommonParent = findNearestCommonParent(V, a, b);
            int subTreeSize = getSubTreeSize(nearestCommonParent);
            
            sb.append("#" + t + " " + nearestCommonParent + " " + subTreeSize + "\n");
		}
        System.out.println(sb.toString());
	}
    
    private static int findNearestCommonParent(int V, int a, int b) {
        boolean[] visited = new boolean[V + 1];
        
        findCommonParent(a, visited);
        return findCommonParent(b, visited);
    }
    
    private static int findCommonParent(int cur, boolean[] visited) {
        int parent = nodes[cur].parent;
        
        visited[cur] = true;
        if (visited[parent]) return parent;
        if (parent == 0) return -1;
        return findCommonParent(parent, visited);
    }
    
    private static int getSubTreeSize(int start) {
        int subTreeSize = 0;
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        que.offer(start);
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            subTreeSize++;
            
            for (int child : nodes[cur].children) {
                que.offer(child);
            }
        }
        
        return subTreeSize;
    }
}