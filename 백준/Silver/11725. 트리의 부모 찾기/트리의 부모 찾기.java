import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<Integer>[] graph;
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
        }

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node].add(node2);
            graph[node2].add(node);
        }
        
        int[] parent = new int[n + 1];
        bfs(1, parent);

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i] + "\n");
        }
        
        System.out.println(sb.toString());
    }

    private static void bfs(int start, int[] parent) {
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        que.offer(start);

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph[cur]) {
                if (visit[next])
                    continue;
                que.offer(next);
                visit[next] = true;
                parent[next] = cur;
            }
        }
    }
}