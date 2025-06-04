import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> hashSet = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (hashSet.contains(name)) pq.offer(name);
        }

        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }
}
