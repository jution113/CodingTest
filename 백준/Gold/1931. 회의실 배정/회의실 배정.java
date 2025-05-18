import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int prevEnd;
    static int cnt = 0;
    static PriorityQueue<Meeting> pq = new PriorityQueue<> ((m1, m2) -> {
        if (m1.end == m2.end) return Integer.compare(m1.start, m2.start);
        return Integer.compare(m1.end, m2.end);
    });

    static class Meeting {
        int start;
        int end;
        
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start, end));
        }

        prevEnd = pq.poll().end;
        cnt++;
        while (!pq.isEmpty()) {
            Meeting m = pq.poll();
            if (m.start < prevEnd) continue;
            prevEnd = m.end;
            cnt++;
        }

        System.out.println(cnt);
    }
}