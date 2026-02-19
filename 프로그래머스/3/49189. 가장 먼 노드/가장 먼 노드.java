import java.util.*;

class Solution {
    int maxDepthNodeCnt;
    
    static class Node {
        int num;
        int depth;
        
        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
    
    public int solution(int n, int[][] edge) {
        maxDepthNodeCnt = 1;
        HashMap<Integer, Integer> nodeCntBydepth = new HashMap<> ();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int[] edgeInfo : edge) {
            graph[edgeInfo[0]].add(edgeInfo[1]);
            graph[edgeInfo[1]].add(edgeInfo[0]);
        }
        
        bfs(n, graph);
        
        return maxDepthNodeCnt;
    }
    
    private void bfs(int n, ArrayList<Integer>[] graph) {
        
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(new Node(1, 0));
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        int maxDepth = 0;
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            for (int nextNodeNum : graph[node.num]) {
                if (visited[nextNodeNum])
                    continue;
                visited[nextNodeNum] = true;
                que.offer(new Node(nextNodeNum, node.depth + 1));
                
                if (maxDepth < node.depth + 1) {
                    maxDepth = node.depth + 1;
                    maxDepthNodeCnt = 1;
                } else {
                    maxDepthNodeCnt++;
                }
            }
        }
    }
}