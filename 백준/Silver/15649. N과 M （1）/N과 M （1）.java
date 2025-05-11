import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static List<Integer> peeks = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        perm(0);
        System.out.print(sb);
    }

    static void perm(int peekCnt) {
        if (peekCnt == M) {
            for (Integer num : peeks) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            peeks.add(i);
            visited[i] = true;
            perm(peekCnt + 1);
            peeks.remove(peeks.size() - 1);
            visited[i] = false;
        }
    }
}
