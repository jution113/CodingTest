import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int maxDis;
    private static int maxItemSum;
    private static int[] items;
    private static ArrayList<int[]>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        n = Integer.parseInt(st.nextToken());
        maxDis = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine()); 
        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
                
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine()); 
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            
            graph[node1].add(new int[] {node2, dis});
            graph[node2].add(new int[] {node1, dis});
        }
        
        maxItemSum = 0;
        
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        
        System.out.println(maxItemSum);
    }
    
    private static void bfs(int start) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        // nodeNum, disSum
        que.offer(new int[] {start, 0});
        
        boolean[] visit = new boolean[n + 1];
        
        int[] minDisMemo = new int[n + 1];
        Arrays.fill(minDisMemo, Integer.MAX_VALUE);
        minDisMemo[start] = 0;
        
        int itemSum = 0;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            if (!visit[cur[0]]) {
                itemSum += items[cur[0]];
                visit[cur[0]] = true;
            }
            
            for (int[] next : graph[cur[0]]) {
                if (cur[1] + next[1] >= minDisMemo[next[0]] || cur[1] + next[1] > maxDis) continue;
                que.offer(new int[] {next[0], cur[1] + next[1]});
            }
        }
        
        maxItemSum = Math.max(itemSum, maxItemSum);
    }
}