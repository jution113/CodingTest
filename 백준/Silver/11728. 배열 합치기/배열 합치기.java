import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static PriorityQueue<Integer> pq = new PriorityQueue<> ();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) pq.offer(Integer.parseInt(st.nextToken()));
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);
    }
}
