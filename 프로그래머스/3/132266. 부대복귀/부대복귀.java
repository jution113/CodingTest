import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] minDistanceMemo = new int[n + 1];
        Arrays.fill(minDistanceMemo, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {destination, 0});
        minDistanceMemo[destination] = 0;
        
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int cur = node[0];
            int distance = node[1];
            
            for (int next : graph[cur]) {
                if (distance + 1 >= minDistanceMemo[next])
                    continue;
                
                minDistanceMemo[next] = distance + 1;
                
                pq.offer(new int[] {next, distance + 1});
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = minDistanceMemo[sources[i]] == Integer.MAX_VALUE ? -1 : minDistanceMemo[sources[i]];
        }
        
        return answer;
    }
}