import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] vertexArr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        vertexArr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st =  new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            vertexArr[A][B] = 1;
            vertexArr[B][A] = 1;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int startV) {
        sb.append(startV).append(" ");
        visited[startV] = true;
        for (int nextV = 1; nextV <= N; nextV++) {
            if (vertexArr[startV][nextV] == 1 && !visited[nextV]) {
                dfs(nextV);
            }
        }
    }

    static void bfs(int startv) {
        Queue<Integer> que = new LinkedList<> ();
        que.add(startv);
        visited[startv] = true;
        sb.append(startv).append(" ");

        while (!que.isEmpty()) {
            int curV = que.poll();
            for (int nextV = 1; nextV <= N; nextV++) {
                if (vertexArr[curV][nextV] == 1 && !visited[nextV]) {
                    visited[nextV] = true;
                    que.offer(nextV);
                    sb.append(nextV).append(" ");
                }
            }
        }

    }
}
