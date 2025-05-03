import java.io.*;
import java.util.*;

public class Main {
    static int[] move = {-1, 1, 2};
    static boolean[] visited = new boolean[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.print(bfs(N, K));
    }

    static int bfs(int start, int end) {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, start));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            int pos = info.pos;
            if (pos == end)
                return info.time;

            for (int i = 0; i < 3; i++) {
                int next = i < 2 ? pos + move[i] : pos * move[i];
                if (next < 0 || next >= visited.length || visited[next]) continue;
                visited[next] = true;
                queue.offer(new Info(info.time + 1, next));
            }
        }
        return -1;
    }

    static class Info {
        int time;
        int pos;

        public Info(int time, int pos) {
            this.time = time;
            this.pos = pos;
        }
    }
}
