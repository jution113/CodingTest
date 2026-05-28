import java.util.*;

class Solution {
    private int n;
    private int maxSheep;
    private int[] info;
    private ArrayList<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        this.info = info;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<> ();
        for (int[] edge : edges) graph[edge[0]].add(edge[1]);
        
        maxSheep = 0;
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(1, 0, visited);
        
        return maxSheep;
    }
    
    private void dfs(int sheep, int wolf, boolean[] visited) {
        maxSheep = Math.max(maxSheep, sheep);
        
        for (int s = 0; s < n; s++) {
            if (visited[s]) {
                for (int e : graph[s]) {
                    if (!visited[e]) {
                        int nextSheep = sheep + (info[e] == 0 ? 1 : 0);
                        int nextWolf = wolf + (info[e] == 1 ? 1 : 0);
                        if (nextSheep <= nextWolf) continue;
                        
                        visited[e] = true;
                        dfs(nextSheep, nextWolf, visited);
                        visited[e] = false;
                    }
                }
            }
        }
    }
}