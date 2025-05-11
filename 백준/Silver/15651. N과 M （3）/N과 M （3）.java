import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer> peeks = new ArrayList<> ();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        solve(0);
        System.out.print(sb);
    }

    static void solve(int peekCnt) {
        if (peekCnt == M) {
            makeRes();
            return ;
        }

        for (int i = 1; i <= N; i++) {
            peeks.add(i);
            solve(peekCnt + 1);
            peeks.remove(peeks.size() - 1);
        }
    }

    static void makeRes() {
        for (Integer num : peeks) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
