import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static List<Integer> peeks = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        comb(1, 0);
        System.out.print(sb);
    }

    static void comb(int start, int peekCnt) {
        if (peekCnt == M) {
            for (Integer num : peeks) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for (int i = start; i <= N; i++) {
            peeks.add(i);
            comb(i + 1, peekCnt + 1);
            peeks.remove(peeks.size() - 1);
        }
    }
}