import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    static class Doc {
        int priority;
        int order;

        public Doc(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int cnt = 0;
            Queue<Doc> queue = new LinkedList<> ();
            PriorityQueue<Integer> pq = new PriorityQueue<> (Comparator.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int o = 0; o < N; o++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Doc(priority, o));
                pq.offer(priority);
            }
            while (queue.peek().order != M || pq.peek() != queue.peek().priority) {
                Doc doc = queue.poll();
                if (pq.peek() == doc.priority) {
                    pq.poll();
                    cnt++;
                    continue;
                }
                queue.offer(doc);
            }
            sb.append(cnt + 1).append("\n");
        }
        System.out.println(sb);
    }
}
