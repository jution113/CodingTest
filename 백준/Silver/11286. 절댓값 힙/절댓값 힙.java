import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Num> pq = new PriorityQueue<> ((n1, n2) -> {
        if (n1.abs - n2.abs != 0) return Integer.compare(n1.abs, n2.abs);
        return Integer.compare(n1.original, n2.original);
    });
    static StringBuilder sb = new StringBuilder();

    static class Num {
        int original;
        int abs;

        public Num(int original, int abs) {
            this.original = original;
            this.abs = abs;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int e = Integer.parseInt(br.readLine());

            if (e == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll().original);
                }
                sb.append("\n");
            } else {
                pq.add(new Num(e, Math.abs(e)));
            }
        }
        System.out.println(sb);
    }
}
