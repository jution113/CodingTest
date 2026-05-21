import java.util.*;

class Solution {
    private int maxSheep;
    private int[] info;
    private ArrayList<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) graph[i] = new ArrayList<> ();
        for (int[] edge : edges) graph[edge[0]].add(edge[1]);
        
        maxSheep = 0;
        bfs(0);
        
        return maxSheep;
    }
    
    private void bfs(int start) {
        // [0] = node, [1] = sheep, [2] = wolf, [3] = visit
        ArrayDeque<long[]> que = new ArrayDeque<> ();
        que.offer(new long[] {start, 1, 0, 1});
        
        while(!que.isEmpty()) {
            long[] cur = que.poll();
            long node = cur[0];
            long sheep = cur[1];
            long wolf = cur[2];
            long visit = cur[3];
            
            maxSheep = Math.max(maxSheep, (int) sheep);
            
            for (int reVisit = 0; reVisit < info.length; reVisit++) {
                // 재방문 시,
                if ((visit & (1 << reVisit)) != 0) {
                    // 재방문 노드의 자식 순회
                    for (int reVisitChild : graph[reVisit]) {
                        // 재방문 노드의 자식도 재방문이면 탐색하지 않음
                        if ((visit & (1 << reVisitChild)) != 0) continue;
                        long nextSheep = info[reVisitChild] == 0 ? sheep + 1 : sheep;
                        long nextWolf = info[reVisitChild] == 1 ? wolf + 1 : wolf;
                        if (nextSheep <= nextWolf) continue;
                        long nextVisit = visit | (1 << reVisitChild);
                        que.offer(new long[] {reVisitChild, nextSheep, nextWolf, nextVisit});
                    }
                }
            }
        }
    }
}