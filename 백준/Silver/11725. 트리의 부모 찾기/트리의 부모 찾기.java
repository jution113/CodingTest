import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        int[] parents = new int[N + 1];
        
        bfs(N, graph, parents);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i] + "\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void bfs(int N, ArrayList<Integer>[] graph, int[] parents) {
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        que.offer(1);

        boolean[] visited = new boolean[N + 1];
        
        while (!que.isEmpty()) {
            int start = que.poll();
            
            for (int end : graph[start]) {
                if (!visited[end]) {
                    visited[end] = true;
                    que.offer(end);
                    parents[end] = start;
                }
            }
        }
    }
}