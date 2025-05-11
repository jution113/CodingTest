import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer> peeks = new ArrayList<> ();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        solve(1, 0);
        System.out.print(sb);
    }

    static void solve(int start, int peekCnt) {
        if (peekCnt == M) {
            makeRes();
            return ;
        }

        for (int i = start; i <= N; i++) {
            peeks.add(i);
            solve(i, peekCnt + 1);
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
