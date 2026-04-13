import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<int[]>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            graph[a].add(new int[] {b, t});
        }
        
        // x에서 x를 제외한 모든 노드에 대한 최단시간 계산
        int[] xToNminT = new int[n + 1];
        Arrays.fill(xToNminT, Integer.MAX_VALUE);
        xToNminT[x] = 0;
        
        dijkstra(x, xToNminT);
        
        // x를 제외한 모든 노드에서 x에 대한 최단시간 계산
        int[] nToXminT = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (i == x)
                continue;
            int[] iToNminT = new int[n + 1];
            Arrays.fill(iToNminT, Integer.MAX_VALUE);
            iToNminT[i] = 0;
            dijkstra(i, iToNminT);
            nToXminT[i] = iToNminT[x];
        }
        
        // 최단시간 중 최장시간 계산
        int maxT = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxT = Math.max(xToNminT[i] + nToXminT[i], maxT);
        }
        
        System.out.println(maxT);
    }
    
    private static void dijkstra(int start, int[] minTimes) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        // [0] = node num, [1] = time sum
        que.offer(new int[] {start, 0});
        
        while (!que.isEmpty()) {
            int[] node = que.poll();
            
            for (int[] nextNode : graph[node[0]]) {
                if (node[1] + nextNode[1] >= minTimes[nextNode[0]])
                    continue;
                que.offer(new int[] {nextNode[0], node[1] + nextNode[1]});
                minTimes[nextNode[0]] = node[1] + nextNode[1];
            }
        }
    }
}