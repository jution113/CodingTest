import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<> (Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int e = Integer.parseInt(br.readLine());
            if (e == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.add(e);
            }
        }
        System.out.println(sb);
    }
}
