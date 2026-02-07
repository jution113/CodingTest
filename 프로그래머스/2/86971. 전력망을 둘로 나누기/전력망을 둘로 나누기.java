import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            int diff = bfs(v1, v2, graph, n);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    int bfs(int v1, int v2, ArrayList<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n + 1];
        visited[v1] = true;
        
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        que.offer(v2);
        
        int part1 = 0;
        
        while (!que.isEmpty()) {
            int start = que.poll();
            visited[start] = true;
            part1++;
                
            for (int next : graph[start]) {
                if (!visited[next]) {
                    que.offer(next);
                }
            }
        }
        
        int part2 = n - part1;
        return Math.max(part1, part2) - Math.min(part1, part2);
    }
}