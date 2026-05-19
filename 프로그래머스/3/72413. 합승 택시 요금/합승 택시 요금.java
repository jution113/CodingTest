import java.util.*;

class Solution {
    private int n;
    private ArrayList<Node>[] graph;
    
    private class Node {
        int num;
        int dis;
        
        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<> ();
        for (int[] f : fares) {
            graph[f[0]].add(new Node(f[1], f[2]));
            graph[f[1]].add(new Node(f[0], f[2]));
        }

        int[] sToAllMinDis = dijkstra(s);
        int answer = Integer.MAX_VALUE;
        
        for (int trans = 1; trans <= n; trans++) {
            int[] transToAllMinDis = dijkstra(trans);
            answer = Math.min(answer, sToAllMinDis[trans] + transToAllMinDis[a] + transToAllMinDis[b]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int s) {
        int[] minDis = new int[n + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[s] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<> ((a, b) -> {
            return Integer.compare(a.dis, b.dis);
        });
        pq.offer(new Node(s, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for (Node next : graph[cur.num]) {
                if (cur.dis + next.dis >= minDis[next.num]) continue;
                minDis[next.num] = cur.dis + next.dis;
                pq.offer(new Node(next.num, cur.dis + next.dis));
            }
        }
        
        return minDis;
    }
}