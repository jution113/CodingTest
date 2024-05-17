import java.io.*;
import java.util.*;

public class Main {
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];

        recur(N, 0, dp);

        System.out.println(minCnt);
    }

    static void recur(int n, int cnt, int[] dp) {
        if (n == 1) {
            if (cnt < minCnt) {
                minCnt = cnt;
//                System.out.println(cnt + " : " + n);
            }
            return;
        }

//        System.out.println(cnt + " : " + n);

        if (n % 3 == 0) {
            int q1 = n / 3;
            if (dp[q1] == 0 || cnt < dp[q1]) {
                dp[q1] = cnt;
                recur(q1, cnt + 1, dp);
            }
        }

        if(n % 2 == 0) {
            int q1 = n / 2;
            if (dp[q1] == 0 || cnt < dp[q1]) {
                dp[q1] = cnt;
                recur(q1, cnt + 1, dp);
            }
        }

        int q3 = n - 1;
        if (dp[q3] == 0 || cnt < dp[q3]) {
            dp[q3] = cnt;
            recur(q3, cnt + 1, dp);
        }
    }
}
