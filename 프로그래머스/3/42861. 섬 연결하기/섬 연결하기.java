import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        HashMap<Integer, Integer> [] costGraph = new HashMap [n];
        for (int i = 0; i < n; i++) {
            costGraph[i] = new HashMap<> ();
        }
        
        for (int[] costInfo : costs) {
            int start = costInfo[0];
            int end = costInfo[1];
            int cost = costInfo[2];
            
            costGraph[start].put(end, cost);
            costGraph[end].put(start, cost);       
        }
        
        return bfs(n, costGraph);
    }
    
    private int bfs(int n, HashMap<Integer, Integer> [] costGraph) {
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});
        
        boolean[] visited = new boolean[n];
        int visitedCnt = 0;
        int totalCost = 0;

        while(!pq.isEmpty()) {
            int[] start = pq.poll();
            
            if (visited[start[0]]) {
                continue;
            }
            
            visited[start[0]] = true;
            visitedCnt++;
            
            totalCost += start[1];
            
            if (visitedCnt == n) {
                break;
            }
            
            for (Map.Entry entrySet : costGraph[start[0]].entrySet()) {
                int end = (int) entrySet.getKey();
                int cost = (int) entrySet.getValue();
                
                if (!visited[end]) {
                    pq.offer(new int[] {end, cost});
                }
            }
        }
                
        return totalCost;
    }
}