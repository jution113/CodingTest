import java.util.*;

class Solution {
    private ArrayList<int[]>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<> ();
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int dist = fare[2];
            
            graph[start].add(new int[] {end, dist});
            graph[end].add(new int[] {start, dist});
        }
        
        
        int[] minDistOfS = new int[n + 1];
        int[] minDistOfA = new int[n + 1];
        int[] minDistOfB = new int[n + 1];
        dijkstra(s, minDistOfS);
        dijkstra(a, minDistOfA);
        dijkstra(b, minDistOfB);

        int answer = Integer.MAX_VALUE;
        
        for (int mid = 1; mid <= n; mid++) {
            int totalDist = minDistOfS[mid] + minDistOfA[mid] + minDistOfB[mid];
            answer = Math.min(answer, totalDist);
        }
        
        return answer;
    }
    
    private void dijkstra(int start, int[] minDist) {
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.offer(new int[] {start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            for (int[] next : graph[cur[0]]) {
                int nextDist = next[1] + cur[1];
                
                if (minDist[next[0]] < nextDist)
                    continue;
                minDist[next[0]] = nextDist;
                pq.offer(new int[] {next[0], nextDist});
            }
        }
    }
}