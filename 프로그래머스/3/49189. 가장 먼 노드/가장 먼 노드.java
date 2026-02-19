import java.util.*;

class Solution {
    int maxDepth;
    
    static class Node {
        int num;
        int depth;
        
        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
    
    public int solution(int n, int[][] edge) {
        maxDepth = 0;
        HashMap<Integer, Integer> nodeCntBydepth = new HashMap<> ();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int[] edgeInfo : edge) {
            graph[edgeInfo[0]].add(edgeInfo[1]);
            graph[edgeInfo[1]].add(edgeInfo[0]);
        }
        
        bfs(n, graph, nodeCntBydepth);
        
        return nodeCntBydepth.get(maxDepth);
    }
    
    private void bfs(int n, ArrayList<Integer>[] graph, HashMap<Integer, Integer> nodeCntBydepth) {
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(new Node(1, 0));
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        nodeCntBydepth.put(0, 1);
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            for (int nextNodeNum : graph[node.num]) {
                if (visited[nextNodeNum])
                    continue;
                visited[nextNodeNum] = true;
                que.offer(new Node(nextNodeNum, node.depth + 1));
                maxDepth = Math.max(maxDepth, node.depth + 1);
                nodeCntBydepth.put(node.depth + 1, nodeCntBydepth.getOrDefault(node.depth + 1, 0) + 1);
            }
        }
    }
}