import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    HashMap<Integer, Integer> sourceIdxByVal;
    int[] answer;
    
    
    static class Node {
        int num;
        int val;
        
        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n + 1];
        
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            
            if (graph[start] == null) {
                graph[start] = new ArrayList<> ();
            }
            graph[start].add(end);
            
            if (graph[end] == null) {
                graph[end] = new ArrayList<> ();
            }
            graph[end].add(start);
        }
        
        sourceIdxByVal = new HashMap<> ();
        for (int i = 0; i < sources.length; i++) {
            sourceIdxByVal.put(sources[i], i);
        }
        
        answer = new int[sources.length];
        Arrays.fill(answer, -1);
        
        bfs(destination, n);
        
        return answer;
    }
    
    private void bfs(int start, int n) {
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(new Node(start, 0));
        
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            if (sourceIdxByVal.containsKey(node.num)) {
                answer[sourceIdxByVal.get(node.num)] = node.val;
            }
            
            for (int next : graph[node.num]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(new Node(next, node.val + 1));
                }
            }
        }
        
    }
}