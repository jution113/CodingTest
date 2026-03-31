import java.util.*;

class Solution {
    private int[][] graph;
    private int n;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new int[n + 1][n + 1];
        this.n = n;
        
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }
        
        int[] sToTransFares = new int[n + 1];
        int[] aToTransFares = new int[n + 1];
        int[] bToTransFares = new int[n + 1];
        
        System.out.println(n);
        
        Arrays.fill(sToTransFares, Integer.MAX_VALUE);
        Arrays.fill(aToTransFares, Integer.MAX_VALUE);
        Arrays.fill(bToTransFares, Integer.MAX_VALUE);
        
        dijkstra(s, sToTransFares);
        dijkstra(a, aToTransFares);
        dijkstra(b, bToTransFares);
        
        int minFares = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int fare = sToTransFares[i] + aToTransFares[i] + bToTransFares[i];
            minFares = Math.min(minFares, fare);
        }
        
        return minFares;
    }
    
    private void dijkstra(int start, int[] minFareMemos) {
        minFareMemos[start] = 0;
        
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(new int[] {start, 0});
        
        while (!que.isEmpty()) {
            int[] curNode = que.poll();
            int curNum = curNode[0];
            int fareSum = curNode[1];
            
            for (int nextNum = 1; nextNum <= n; nextNum++) {
                int nextFare = graph[curNum][nextNum];
                if (nextFare == 0) continue;
                
                int nextFareSum = fareSum + nextFare;
                if (nextFareSum >= minFareMemos[nextNum]) continue;
                
                minFareMemos[nextNum] = nextFareSum;
                que.offer(new int[] {nextNum, nextFareSum});
            }
        }
    }
}