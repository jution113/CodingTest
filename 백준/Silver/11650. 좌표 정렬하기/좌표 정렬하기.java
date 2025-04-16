import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pq = new PriorityQueue<> ();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(x, y));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.print(sb);
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x != p.x) {
                return this.x - p.x;
            } else {
                return this.y - p.y;
            }
        }
    }
}